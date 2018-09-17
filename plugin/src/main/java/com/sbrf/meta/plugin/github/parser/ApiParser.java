package com.sbrf.meta.plugin.github.parser;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.BodyDeclaration;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.TypeDeclaration;
import com.sbrf.meta.plugin.dto.api.ApiStorage;

import java.io.File;
import java.util.Map;

public class ApiParser{
    private final CompilationUnit unit;
    public ApiParser(File file) {
        try {
            unit = JavaParser.parse(file);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void parse(ApiStorage storage) {
        for (TypeDeclaration<?> type : unit.getTypes()) {
            if (type instanceof ClassOrInterfaceDeclaration) {
                ClassOrInterfaceDeclaration declaration = (ClassOrInterfaceDeclaration) type;
                parseType(type, declaration, storage);
            }
        }
    }

    private void parseType(TypeDeclaration<?> type, ClassOrInterfaceDeclaration declaration, ApiStorage storage) {
        if (Util.hasAnnotation(declaration, "Api")) {
            String pack = unit.getPackageDeclaration().get().toString();
            String apiName = pack.substring(8, pack.length() - 3) + "." + type.getNameAsString();
            for (BodyDeclaration<?> member : declaration.getMembers()) {
                if (member instanceof MethodDeclaration) {
                    parseApiMethod(member, apiName, storage);
                }
            }
        }
    }

    private void parseApiMethod(BodyDeclaration member, String apiName, ApiStorage storage) {
        String name = "ApiMethod";
        Map<String, String> params = Util.getAnnotationParam(member, name);
        if (params != null) {

        }
    }

}
