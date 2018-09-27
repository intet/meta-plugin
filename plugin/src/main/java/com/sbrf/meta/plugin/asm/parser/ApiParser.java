package com.sbrf.meta.plugin.asm.parser;

import com.sbrf.meta.plugin.asm.util.DtoUtils;
import com.sbrf.meta.plugin.asm.util.NodeUtils;
import com.sbrf.meta.plugin.dto.api.ApiStorage;
import com.sbrf.meta.plugin.dto.api.Dto;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;

import java.util.List;
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
                String desc = mn.signature != null ? mn.signature : mn.desc;
                List<Dto> dto = getSignature(desc, nodes);
                Dto result = getResult(desc, nodes);
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
        return DtoUtils.getDto(resultName.substring(1), nodes);
    }

    private static List<Dto> getSignature(String desc, Map<String, ClassNode> nodes) {
        String signature = desc.substring(desc.indexOf("(") + 1, desc.indexOf(")"));
        return DtoUtils.parseListDto(signature, nodes);
    }

}
