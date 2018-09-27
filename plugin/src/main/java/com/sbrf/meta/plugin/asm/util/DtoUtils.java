package com.sbrf.meta.plugin.asm.util;

import com.sbrf.meta.plugin.dto.api.Dto;
import com.sbrf.meta.plugin.dto.api.DtoContainer;
import org.objectweb.asm.tree.ClassNode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DtoUtils {
    public static Dto getDto(String className, Map<String, ClassNode> nodes) {
        if (className.contains("<")) {
            String container = className.substring(0, className.indexOf("<"));
            String element = className.substring(className.indexOf("<") + 1, className.indexOf(">"));
            return new DtoContainer(container, parseListDto(element, nodes));
        } else if (nodes.get(className) != null) {
            return new Dto(nodes.get(className), nodes);
        } else {
            return new Dto(className);
        }
    }

    public static List<Dto> parseListDto(String signature, Map<String, ClassNode> nodes) {
        if (signature.length() == 0)
            return Collections.emptyList();
        return Arrays.stream(signature.split(";")).map(
                d -> getDto(d.substring(1), nodes)
        ).collect(Collectors.toList());
    }
}
