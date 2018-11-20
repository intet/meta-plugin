package com.sbrf.meta.plugin.asm.util;

import com.sbrf.meta.plugin.dto.api.ApiStorage;
import com.sbrf.meta.plugin.dto.api.Dto;
import com.sbrf.meta.plugin.dto.api.DtoContainer;
import com.sbrf.meta.plugin.dto.api.GAV;
import com.sbrf.meta.plugin.dto.xml.ClassType;
import com.sbrf.meta.plugin.dto.xml.ModuleType;
import com.sbrf.meta.plugin.dto.xml.TypesType;
import com.sbrf.meta.plugin.util.CollectionUtil;
import org.objectweb.asm.tree.ClassNode;

import java.util.*;
import java.util.stream.Collectors;

public class DtoUtils {

    private static final String EXTENDS = "? extends ";
    private static final String SUPER = "? super ";

    public static String getDto(String className, Map<String, ClassNode> nodes, ApiStorage storage, Map<String, GAV> metaInfo) {
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
            dto = new DtoContainer(container, parseListDto(element, nodes, storage, metaInfo), extend, supper, metaInfo.get(className));
        } else if (nodes.get(className) != null) {
            dto = new Dto(nodes.get(className), nodes, extend, supper, storage, metaInfo);
        } else {
            dto = new Dto(className, extend, supper, metaInfo.get(className));
        }
        storage.addDto(className, dto);
        return className;
    }

    public static List<String> getDto(String[] type, Map<String, ClassNode> nodes, ApiStorage storage, Map<String, GAV> metaInfo) {
        return Arrays.stream(type)
                .map(d -> getDto(d, nodes, storage, metaInfo))
                .collect(Collectors.toList());
    }

    private static List<String> parseListDto(String signature, Map<String, ClassNode> nodes, ApiStorage storage, Map<String, GAV> metaInfo) {
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
        return getDto(split.toArray(new String[]{}), nodes, storage, metaInfo);
    }

    public static ClassType getClassType(String className) {
        ClassType classType = new ClassType();
        classType.setIsArray(className.endsWith("[]"));
        classType.setName(className.replace("[]", ""));
        if (classType.getName().indexOf("<") != -1) {
            classType.setType(className.substring(0, classType.getName().indexOf("<")));
        } else {
            classType.setType(classType.getName());
        }
        return classType;
    }

    public static ClassType getClassType(String dtoClass, Collection<String> types) {
        ClassType classType = DtoUtils.getClassType(dtoClass);
        TypesType arr = new TypesType();
        for (String type : types) {
            arr.getType().add(type);
        }
        classType.setName(dtoClass);
        classType.setTypes(arr);
        return classType;
    }

    public static ModuleType getModule(Map<GAV, ModuleType> moduleMap, GAV gav) {
        ModuleType module = CollectionUtil.get(moduleMap, gav, ModuleType.class);
        module.setGav(gav.toXml());
        return module;
    }

    public static void addDependencies(GAV gav, Map<String, Dto> dtoMap, Map<GAV, Set<GAV>> dependencyMap, String dtoClass) {
        if (gav == null)
            return;
        Dto dto = dtoMap.get(dtoClass);
        if (dto != null && dto.gav != null && !dto.gav.equals(gav)) {
            Set<GAV> dependencies = CollectionUtil.get(dependencyMap, gav, HashSet.class);
            dependencies.add(dto.gav);
        }
    }
}
