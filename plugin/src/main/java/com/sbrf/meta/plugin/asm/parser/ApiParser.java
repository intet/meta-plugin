package com.sbrf.meta.plugin.asm.parser;

import com.sbrf.meta.plugin.asm.util.NodeUtils;
import com.sbrf.meta.plugin.dto.api.ApiStorage;
import com.sbrf.meta.plugin.dto.api.Dto;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
                List<Dto> dto = getDto(mn.desc, nodes);
                Dto result = getResult(mn.desc, nodes);
                storage.addApi(cn.name, mn.name, mn.desc, params.get("apiName"), params.get("version"),
                        dto, result);
            }
        }
        return storage;
    }

    private static Dto getResult(String desc, Map<String, ClassNode> nodes) {
        String resultName = desc.substring(desc.indexOf(")") + 1, desc.length() - 1);
        if (resultName.length() == 0) {
            return new Dto("void");
        }
        resultName = resultName.substring(1);
        return nodes.get(resultName) != null ? new Dto(nodes.get(resultName), nodes) : new Dto(resultName);
    }

    private static List<Dto> getDto(String desc, Map<String, ClassNode> nodes) {
        String signature = desc.substring(desc.indexOf("(") + 1, desc.indexOf(")"));
        if (signature.length() == 0)
            return Collections.emptyList();
        return Arrays.stream(signature.split(";")).map(
                d -> {
                    d = d.substring(1);
                    if (nodes.get(d) != null) {
                        return new Dto(nodes.get(d), nodes);
                    } else {
                        return new Dto(d);
                    }
                }

        ).collect(Collectors.toList());
    }
}
