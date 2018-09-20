package com.sbrf.meta.plugin.asm.util;


import org.objectweb.asm.tree.AnnotationNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class NodeUtils {

    public static boolean hasAnnotation(ClassNode cn, String annotationName) {
        if (cn.invisibleAnnotations != null) {
            for (AnnotationNode annotation : cn.invisibleAnnotations) {
                if (annotation.desc.equals(annotationName)) {
                    return true;
                }
            }
        }
        if (cn.visibleAnnotations != null) {
            for (AnnotationNode annotation : cn.visibleAnnotations) {
                if (annotation.desc.equals(annotationName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static Map<String, String> getAnnotationParams(ClassNode cn, String annotationName) {
        if (cn.invisibleAnnotations != null) {
            for (AnnotationNode annotation : cn.invisibleAnnotations) {
                Map<String, String> result = getAnnotationParams(annotationName, annotation);
                if (result != null) return result;
            }
        }
        if (cn.visibleAnnotations != null) {
            for (AnnotationNode annotation : cn.visibleAnnotations) {
                Map<String, String> result = getAnnotationParams(annotationName, annotation);
                if (result != null) return result;
            }
        }
        return Collections.emptyMap();
    }

    private static Map<String, String> getAnnotationParams(String annotationName, AnnotationNode annotation) {
        if (annotation.desc.equals(annotationName)) {
            Map<String, String> result = new HashMap<>();
            for (int i = 0; i < annotation.values.size(); i += 2) {
                result.put((String) annotation.values.get(i), annotation.values.get(i + 1).toString());
            }
            return result;
        }
        return null;
    }


    public static boolean hasAnnotation(MethodNode cn, String annotationName) {
        if (cn.invisibleAnnotations != null) {
            for (AnnotationNode annotation : cn.invisibleAnnotations) {
                if (annotation.desc.equals(annotationName)) {
                    return true;
                }
            }
        }
        if (cn.visibleAnnotations != null) {
            for (AnnotationNode annotation : cn.visibleAnnotations) {
                if (annotation.desc.equals(annotationName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static Map<String, String> getAnnotationParams(MethodNode cn, String annotationName) {
        if (cn.invisibleAnnotations != null) {
            for (AnnotationNode annotation : cn.invisibleAnnotations) {
                Map<String, String> result = getAnnotationParams(annotationName, annotation);
                if (result != null) return result;
            }
        }
        if (cn.visibleAnnotations != null) {
            for (AnnotationNode annotation : cn.visibleAnnotations) {
                Map<String, String> result = getAnnotationParams(annotationName, annotation);
                if (result != null) return result;
            }
        }
        return Collections.emptyMap();
    }


}
