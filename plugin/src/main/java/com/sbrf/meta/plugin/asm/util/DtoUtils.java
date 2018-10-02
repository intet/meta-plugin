package com.sbrf.meta.plugin.asm.util;

import com.sbrf.meta.plugin.dto.api.Dto;
import com.sbrf.meta.plugin.dto.api.DtoContainer;
import org.objectweb.asm.tree.ClassNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DtoUtils {
    public static Dto getDto(String className, Map<String, ClassNode> nodes) {
        boolean extend = false;
        if (className.startsWith("+")) {
            extend = true;
            className = className.substring(1);
        }
        if (className.contains("<")) {
            String container = className.substring(0, className.indexOf("<"));
            String element = className.substring(className.indexOf("<") + 1, className.lastIndexOf(">"));
            return new DtoContainer(container, parseListDto(element, nodes), extend);
        } else if (nodes.get(className) != null) {
            return new Dto(nodes.get(className), nodes, extend);
        } else {
            return new Dto(className, extend);
        }
    }

    public static List<Dto> parseListDto(String signature, Map<String, ClassNode> nodes) {
        if (signature.length() == 0)
            return Collections.emptyList();
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
            if (c == ';' && bracket == 0) {
                split.add(signature.substring(start, current));
                start = current + 1;
            }
        }
        return split.stream()
                .map(d -> d.startsWith("+") ? "+" + d.substring(2) : d.substring(1))
                .map(d -> getDto(d, nodes)
        ).collect(Collectors.toList());
    }
}
