package com.sbrf.meta.plugin.asm.parser;

import com.sbrf.meta.plugin.dto.api.ApiStorage;
import org.objectweb.asm.tree.ClassNode;

import java.util.Map;

public class ApiImplParser {

    public static void findApiImpl(Map<String, ClassNode> nodes, ApiStorage storage) {
        for (ClassNode cn : nodes.values()) {
            getImplInterface(cn, storage, cn.name, nodes);
        }
    }

    private static void getImplInterface(ClassNode cn, ApiStorage storage, String name, Map<String, ClassNode> nodes) {
        if (cn.interfaces != null) {
            for (String inter : cn.interfaces) {
                if (storage.containsApi(inter)) {
                    System.out.println("Implementation of " + inter + " is " + name);
                    storage.addApiImpl(inter, name);
                }
            }
        }
        if (cn.superName != null) {
            ClassNode classNode = nodes.get(cn.superName);
            if (classNode != null) {
                getImplInterface(classNode, storage, name, nodes);
            }
        }
    }
}
