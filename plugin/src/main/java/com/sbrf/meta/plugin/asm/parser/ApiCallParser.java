package com.sbrf.meta.plugin.asm.parser;

import com.sbrf.meta.plugin.dto.api.ApiStorage;
import com.sbrf.meta.plugin.dto.api.GAV;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;

import java.util.Map;

public class ApiCallParser {
    public static void findCall(Map<String, ClassNode> nodes, Map<String, GAV> metaInfo, ApiStorage storage) {
        for (ClassNode cn : nodes.values()) {
            findCall(storage, cn, nodes, metaInfo.get(cn.name));
        }
    }

    private static void findCall(ApiStorage storage, ClassNode cn, Map<String, ClassNode> nodes, GAV gav) {
        for (MethodNode mn : cn.methods) {
            findCallInMethod(mn, storage, cn.name, nodes, gav);
        }
    }

    private static void findCallInMethod(MethodNode mn, ApiStorage storage, String className, Map<String, ClassNode> nodes, GAV gav) {
        for (AbstractInsnNode ain : mn.instructions.toArray()) {
            if (ain.getType() == AbstractInsnNode.METHOD_INSN) {
                MethodInsnNode methodNode = (MethodInsnNode) ain;
                String owner = methodNode.owner;
                String apiClass = checkImplement(owner, storage, nodes);
                if (apiClass != null) {
                    storage.addCall(apiClass, className, gav, methodNode.name, methodNode.desc);
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
