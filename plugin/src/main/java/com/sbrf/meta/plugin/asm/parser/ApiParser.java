package com.sbrf.meta.plugin.asm.parser;

import com.sbrf.meta.plugin.asm.util.DtoUtils;
import com.sbrf.meta.plugin.asm.util.NodeUtils;
import com.sbrf.meta.plugin.dto.api.ApiStorage;
import com.sbrf.meta.plugin.dto.api.GAV;
import org.apache.bcel.classfile.Utility;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;

import java.util.List;
import java.util.Map;

public class ApiParser {
    public static final String ANNOTATION_NAME = "Lcom/sbt/core/amqp/annotations/Api;";
    public static final String ANNOTATION_METHOD_NAME = "Lcom/sbt/core/amqp/annotations/registry/ApiMethod;";

    public static ApiStorage findApi(Map<String, ClassNode> nodes, Map<String, GAV> metaInfo) {
        ApiStorage storage = new ApiStorage();
        for (ClassNode cn : nodes.values()) {
            // Iterate methods in class
            if (!NodeUtils.hasAnnotation(cn, ANNOTATION_NAME))
                continue;
            for (MethodNode mn : cn.methods) {
                if (!NodeUtils.hasAnnotation(mn, ANNOTATION_METHOD_NAME))
                    continue;
                Map<String, String> params = NodeUtils.getAnnotationParams(mn, ANNOTATION_METHOD_NAME);
                String signature = mn.signature != null ? mn.signature : mn.desc;
                List<String> dto = getSignature(signature, nodes, storage);
                String result = getResult(signature, nodes, storage);
                GAV gav = metaInfo.get(cn.name);
                storage.addApi(cn.name, mn.name, mn.desc, gav,
                        params.get("apiName"), params.get("version"), dto, result);
            }
        }
        return storage;
    }

    private static String getResult(String signature, Map<String, ClassNode> nodes, ApiStorage storage) {
        String type = Utility.methodSignatureReturnType(signature);
        return DtoUtils.getDto(new String[]{type}, nodes, storage).get(0);
    }

    private static List<String> getSignature(String signature, Map<String, ClassNode> nodes, ApiStorage storage) {
        String[] types = Utility.methodSignatureArgumentTypes(signature);
        return DtoUtils.getDto(types, nodes, storage);
    }

}
