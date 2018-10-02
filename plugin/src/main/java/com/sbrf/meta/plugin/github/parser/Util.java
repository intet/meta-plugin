package com.sbrf.meta.plugin.github.parser;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.BodyDeclaration;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.expr.AnnotationExpr;
import com.github.javaparser.ast.expr.MemberValuePair;
import com.github.javaparser.ast.expr.SimpleName;
import com.github.javaparser.resolution.types.ResolvedType;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;

import java.util.HashMap;
import java.util.Map;

public class Util {
    static boolean hasAnnotation(ClassOrInterfaceDeclaration declaration, String name) {
        for (AnnotationExpr annotation : declaration.getAnnotations()) {
            if (annotation.getName().getIdentifier().equals(name)) {
                return true;
            }
        }
        return false;
    }

    static Map<String, String> getAnnotationParam(BodyDeclaration member, String name) {
        for (Object annotation : member.getAnnotations()) {
            if (annotation instanceof AnnotationExpr) {
                if (((AnnotationExpr) annotation).getName().getId().equals(name)) {
                    Map<String, String> params = new HashMap<>();
                    for (Node node : ((AnnotationExpr) annotation).getChildNodes()) {
                        if (node instanceof MemberValuePair) {
                            MemberValuePair param = (MemberValuePair) node;
                            params.put(param.getName().asString(), param.getValue().toString());
                        }
                    }
                    return params;
                }
            }
        }
        return null;
    }

    public static String getMethodSignature(SimpleName method, NodeList<Parameter> parameters, JavaParserFacade facade) {
        StringBuilder builder = new StringBuilder(method.asString());
        builder.append("(");
        for (Parameter parameter : parameters) {
            ResolvedType type = facade.getType(parameter);
            String name = type.asReferenceType().getQualifiedName();
            builder.append("L");
            builder.append(convertToSlash(name));
            builder.append(";");
        }
        builder.append(")");
        return builder.toString();
    }

    public static String convertToSlash(String str) {
        return str.replaceAll("\\.", "/");
    }
}
