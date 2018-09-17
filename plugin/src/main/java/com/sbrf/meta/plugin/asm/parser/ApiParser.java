package com.sbrf.meta.plugin.asm.parser;

import com.sbrf.meta.plugin.dto.api.ApiStorage;
import com.sbrf.meta.plugin.asm.util.NodeUtils;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;

import java.util.Map;

public class ApiParser {
    public static final String ANNOTATION_NAME = "Lcom/sbt/core/amqp/annotations/Api;";
    public static final String ANNOTATION_METHOD_NAME = "Lcom/sbt/core/amqp/annotations/registry/ApiMethod;";

    public static ApiStorage findApi(Map<String, ClassNode> nodes) {
        ApiStorage storage = new ApiStorage();
        for (ClassNode cn : nodes.values()) {
            // Iterate methods in class
            if (cn.invisibleAnnotations == null)
                continue;
            if (!NodeUtils.hasAnnotation(cn, ANNOTATION_NAME))
                continue;
            for (MethodNode mn : cn.methods) {
                if (!NodeUtils.hasAnnotation(mn, ANNOTATION_METHOD_NAME))
                    continue;
                Map<String, Object> params = NodeUtils.getAnnotationParams(mn, ANNOTATION_METHOD_NAME);
                System.out.println("Api method " + mn.name + "(" + params.get("apiName") + ", version " + params.get("version") + ")" + " in class " + cn.name);
                storage.addApi(cn.name, mn.name, mn.desc);
            }
        }
        return storage;
    }
}
