package com.sbrf.meta.plugin.asm.parser;

import com.sbrf.meta.plugin.asm.util.NodeUtils;
import com.sbrf.meta.plugin.dto.api.ApiStorage;
import com.sbrf.meta.plugin.dto.api.GAV;
import org.apache.bcel.classfile.Utility;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.sbrf.meta.plugin.asm.util.DtoUtils.getDto;

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
                findMethod(nodes, metaInfo, storage, cn, mn);
            }
        }
        return storage;
    }

    private static void findMethod(Map<String, ClassNode> nodes, Map<String, GAV> metaInfo, ApiStorage storage, ClassNode cn, MethodNode mn) {
        String signature = mn.signature != null ? mn.signature : mn.desc;
        List<String> input = getSignature(signature, nodes, storage, metaInfo);
        List<String> exceptions = getExceptions(mn.exceptions, nodes, storage, metaInfo);
        String output = getResult(signature, nodes, storage, metaInfo);
        GAV gav = metaInfo.get(cn.name);

        String logicalName;
        String versionCode;
        if (!NodeUtils.hasAnnotation(mn, ANNOTATION_METHOD_NAME)) {
            logicalName = mn.name;
            versionCode = "nono";
        } else {
            Map<String, String> params = NodeUtils.getAnnotationParams(mn, ANNOTATION_METHOD_NAME);
            if (params.get("shortNameRu") != null) {
                logicalName = params.get("shortNameRu");
                versionCode = params.get("major") + "." + params.get("minor");
            } else {
                logicalName = params.get("apiName");
                versionCode = params.get("version");
            }
        }

        storage.addApi(cn.name, logicalName, mn.name, mn.desc, gav,
                versionCode, input, output, exceptions);
    }

    private static String getResult(String signature, Map<String, ClassNode> nodes, ApiStorage storage, Map<String, GAV> metaInfo) {
        String type = Utility.methodSignatureReturnType(signature);
        return getDto(new String[]{type}, nodes, storage, metaInfo).get(0);
    }

    private static List<String> getSignature(String signature, Map<String, ClassNode> nodes, ApiStorage storage, Map<String, GAV> metaInfo) {
        if (signature.startsWith("<"))
            signature = signature.substring(signature.indexOf(">") + 1);
        String[] types = Utility.methodSignatureArgumentTypes(signature);
        return getDto(types, nodes, storage, metaInfo);
    }

    private static List<String> getExceptions(List<String> exceptions, Map<String, ClassNode> nodes, ApiStorage storage, Map<String, GAV> metaInfo) {
        if (exceptions == null) {
            return Collections.emptyList();
        }
        return exceptions.stream()
                .map(d -> d.replace('/', '.'))
                .map(d -> getDto(d, nodes, storage, metaInfo))
                .collect(Collectors.toList());
    }

    public static String join(Collection<String> collection, String before, String after) {
        StringBuffer result = new StringBuffer();
        for (String item : collection) {
            result.append(before);
            result.append(item);
            result.append(after);
        }
        return result.toString();
    }

}
