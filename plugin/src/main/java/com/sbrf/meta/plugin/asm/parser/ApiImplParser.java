package com.sbrf.meta.plugin.asm.parser;

import com.sbrf.meta.plugin.dto.api.ApiStorage;
import com.sbrf.meta.plugin.launch.GAV;
import org.objectweb.asm.tree.ClassNode;

import java.util.Map;

public class ApiImplParser {

    public static void findApiImpl(Map<String, ClassNode> nodes, Map<String, GAV> metaInfo, ApiStorage storage) {
        for (ClassNode cn : nodes.values()) {
            getImplInterface(cn, storage, cn.name, metaInfo.get(cn.name), nodes);
        }
    }

    private static void getImplInterface(ClassNode cn, ApiStorage storage, String name, GAV gav, Map<String, ClassNode> nodes) {
        if (cn.interfaces != null) {
            for (String inter : cn.interfaces) {
                if (storage.containsApi(inter)) {
                    storage.addApiImpl(inter, name, gav);
                }
            }
        }
        if (cn.superName != null) {
            ClassNode classNode = nodes.get(cn.superName);
            if (classNode != null) {
                getImplInterface(classNode, storage, name, gav, nodes);
            }
        }
    }
}
