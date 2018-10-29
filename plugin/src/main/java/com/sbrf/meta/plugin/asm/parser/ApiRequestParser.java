package com.sbrf.meta.plugin.asm.parser;

import com.sbrf.meta.plugin.asm.util.NodeUtils;
import com.sbrf.meta.plugin.dto.api.ApiStorage;
import org.objectweb.asm.tree.ClassNode;

import java.util.Map;

public class ApiRequestParser {
    public static final String ANNOTATION_API_REQUEST_NAME[] = new String[]{
            "Lcom/sbt/core/amqp/annotations/ApiRequest;",
            "Lcom/sbt/core/amqp/annotations/ApiStateless;",
            "Lcom/sbt/core/amqp/annotations/ApiAsync;",
            "Lcom/sbt/core/amqp/annotations/ApiRequestStateless;"};

    public static void findApiRequests(Map<String, ClassNode> nodes, ApiStorage storage) {
        for (ClassNode cn : nodes.values()) {
            // Iterate methods in class
            for (String annotation : ANNOTATION_API_REQUEST_NAME) {
                if (!NodeUtils.hasAnnotation(cn, annotation))
                    continue;
                Map<String, String> params = NodeUtils.getAnnotationParams(cn, annotation);
                if (params.get("api") == null)
                    continue;
                String apiClass = "" + params.get("api");
                apiClass = apiClass.substring(1, apiClass.length() - 1).replace('/', '.');
                if (storage.containsApi(apiClass))
                    storage.addRequest(apiClass, cn.name);
            }
        }
    }
}
