package com.sbrf.meta.plugin.asm.parser;

import com.sbrf.meta.plugin.dto.api.ApiStorage;
import com.sbrf.meta.plugin.asm.util.NodeUtils;
import org.objectweb.asm.tree.ClassNode;

import java.util.Map;

public class ApiRequestParser {
    public static final String ANNOTATION_API_REQUEST_NAME = "Lcom/sbt/core/amqp/annotations/ApiRequest;";

    public static void findApiRequests(Map<String, ClassNode> nodes, ApiStorage storage) {
        for (ClassNode cn : nodes.values()) {
            // Iterate methods in class
            if (cn.invisibleAnnotations == null)
                continue;
            if (!NodeUtils.hasAnnotation(cn, ANNOTATION_API_REQUEST_NAME))
                continue;
            Map<String, Object> params = NodeUtils.getAnnotationParams(cn, ANNOTATION_API_REQUEST_NAME);
            if (params.get("api") == null)
                continue;
            String apiClass = "" + params.get("api");
            apiClass = apiClass.substring(1, apiClass.length() - 1);
            if (storage.containsApi(apiClass))
                storage.addRequest(apiClass, cn.name);
        }
    }
}
