package com.sbrf.meta.plugin.asm.parser;

import com.sbrf.meta.plugin.asm.util.NodeUtils;
import com.sbrf.meta.plugin.dto.api.ApiStorage;
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
            if (!NodeUtils.hasAnnotation(cn, ANNOTATION_NAME))
                continue;
            for (MethodNode mn : cn.methods) {
                if (!NodeUtils.hasAnnotation(mn, ANNOTATION_METHOD_NAME))
                    continue;
                Map<String, String> params = NodeUtils.getAnnotationParams(mn, ANNOTATION_METHOD_NAME);
                storage.addApi(cn.name, mn.name, mn.desc, params.get("apiName"), params.get("version"));
            }
        }
        return storage;
    }
}
