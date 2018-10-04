package com.sbrf.meta.plugin.asm.util;

import com.sbrf.meta.plugin.dto.api.ApiStorage;
import com.sbrf.meta.plugin.dto.api.Dto;
import com.sbrf.meta.plugin.dto.api.DtoContainer;
import org.objectweb.asm.tree.ClassNode;

import java.util.*;
import java.util.stream.Collectors;

public class DtoUtils {

    private static final String EXTENDS = "? extends ";
    private static final String SUPER = "? super ";

    public static String getDto(String className, Map<String, ClassNode> nodes, ApiStorage storage) {
        boolean extend = false;
        boolean supper = false;
        className = className.trim();
        if (className.startsWith(EXTENDS)) {
            extend = true;
            className = className.substring(EXTENDS.length());
        }
        if (className.startsWith(SUPER)) {
            supper = true;
            className = className.substring(SUPER.length());
        }
        if (storage.hasDto(className)) {
            return className;
        }
        Dto dto;
        //Сразу добавляем чтобы избежать зацикливания
        storage.addDto(className, null);
        if (className.contains("<")) {
            String container = className.substring(0, className.indexOf("<"));
            String element = className.substring(className.indexOf("<") + 1, className.lastIndexOf(">"));
            dto = new DtoContainer(container, parseListDto(element, nodes, storage), extend, supper);
        } else if (nodes.get(className) != null) {
            dto = new Dto(nodes.get(className), nodes, extend, supper, storage);
        } else {
            dto = new Dto(className, extend, supper);
        }
        storage.addDto(className, dto);
        return className;
    }

    public static List<String> getDto(String[] type, Map<String, ClassNode> nodes, ApiStorage storage) {
        return Arrays.stream(type)
                .map(d -> getDto(d, nodes, storage))
                .collect(Collectors.toList());
    }

    private static List<String> parseListDto(String signature, Map<String, ClassNode> nodes, ApiStorage storage) {
        if (signature.length() == 0)
            return Collections.emptyList();
        signature = signature + ",";
        int start = 0;
        int current = 0;
        int bracket = 0;
        List<String> split = new ArrayList<>();
        for (; current < signature.length(); current++) {
            char c = signature.charAt(current);
            if (c == '<') {
                bracket++;
                continue;
            }
            if (c == '>') {
                bracket--;
                continue;
            }
            if (c == ',' && bracket == 0) {
                split.add(signature.substring(start, current));
                start = current + 1;
            }
        }
        return getDto(split.toArray(new String[]{}), nodes, storage);
    }
}
