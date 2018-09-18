package com.sbrf.meta.plugin.asm.util;


import org.objectweb.asm.tree.AnnotationNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class NodeUtils {

    public static boolean hasAnnotation(ClassNode cn, String annotationName) {
        for(AnnotationNode annotation: cn.invisibleAnnotations){
            if(annotation.desc.equals(annotationName)){
                return true;
            }
        }
        return false;
    }

    public static Map<String, Object> getAnnotationParams(ClassNode cn, String annotationName) {
        for (AnnotationNode annotation : cn.invisibleAnnotations) {
            if (annotation.desc.equals(annotationName)) {
                Map<String, Object> result = new HashMap<>();
                for (int i = 0; i < annotation.values.size(); i += 2) {
                    result.put((String) annotation.values.get(i), annotation.values.get(i + 1));
                }
                return result;
            }
        }
        return Collections.emptyMap();
    }

    public static boolean hasAnnotation(MethodNode cn, String annotationName) {
        for(AnnotationNode annotation: cn.invisibleAnnotations){
            if(annotation.desc.equals(annotationName)){
                return true;
            }
        }
        return false;
    }

    public static Map<String, String> getAnnotationParams(MethodNode cn, String annotationName) {
        for(AnnotationNode annotation: cn.invisibleAnnotations){
            if(annotation.desc.equals(annotationName)){
                Map<String, String> result = new HashMap<>();
                for(int i = 0; i< annotation.values.size(); i+=2){
                    result.put((String) annotation.values.get(i), annotation.values.get(i + 1).toString());
                }
                return result;
            }
        }
        return Collections.emptyMap();
    }
}
