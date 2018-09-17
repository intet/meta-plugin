package com.sbrf.meta.plugin.asm.parser;

import com.sbrf.meta.plugin.dto.api.ApiStorage;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ApiCallParser {
    /**
     * @return ApiRequest - Api
     */
    public static Map<String, Set<String>> findCall(Map<String, ClassNode> nodes, ApiStorage storage) {
        Map<String, Set<String>> result = new HashMap<>();
        for (ClassNode cn : nodes.values()) {
            Set<String> apiCalls = findCall(storage, cn, nodes);
            if (apiCalls.size() > 0) {
                result.put(cn.name, apiCalls);
            }
        }

        return result;
    }

    private static Set<String> findCall(ApiStorage storage, ClassNode cn, Map<String, ClassNode> nodes) {
        Set<String> result = new HashSet<>();
        for (MethodNode mn : cn.methods) {
            Set<String> apiCalls = new HashSet<>();

            findCallInMethod(mn, storage, cn.name, apiCalls, nodes);
            result.addAll(apiCalls);
        }
        return result;
    }

    private static void findCallInMethod(MethodNode mn, ApiStorage storage, String className, Set<String> apiCalls, Map<String, ClassNode> nodes) {
        for (AbstractInsnNode ain : mn.instructions.toArray()) {
            if (ain.getType() == AbstractInsnNode.METHOD_INSN) {
                MethodInsnNode methodNode = (MethodInsnNode) ain;
                String owner = methodNode.owner;
                String apiCall = checkImplement(owner, storage, nodes);

                if (apiCall != null) {
                    apiCalls.add(apiCall);
                    System.out.println("Class " + className + " call api " + apiCall + ":" + methodNode.name + " (" + methodNode.desc + ")");
                }
            }
        }
    }

    private static String checkImplement(String owner, ApiStorage storage, Map<String, ClassNode> nodes) {
        if (storage.containsApiRequest(owner))
            return storage.getApiByRequest(owner);
        ClassNode classNode = nodes.get(owner);
        if (classNode == null)
            return null;
        if (classNode.superName != null)
            return checkImplement(classNode.superName, storage, nodes);
        return null;
    }
}
