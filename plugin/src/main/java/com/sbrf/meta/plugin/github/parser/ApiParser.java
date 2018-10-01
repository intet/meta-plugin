package com.sbrf.meta.plugin.github.parser;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.BodyDeclaration;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.TypeDeclaration;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;
import com.sbrf.meta.plugin.dto.api.ApiStorage;

import java.util.Map;

public class ApiParser{
    private final CompilationUnit unit;
    private final JavaParserFacade facade;
    private final ApiStorage storage;

    public ApiParser(CompilationUnit unit, JavaParserFacade facade, ApiStorage storage) {
        this.unit = unit;
        this.facade = facade;
        this.storage = storage;
    }

    public void parse() {
        for (TypeDeclaration<?> type : unit.getTypes()) {
            if (type instanceof ClassOrInterfaceDeclaration) {
                ClassOrInterfaceDeclaration declaration = (ClassOrInterfaceDeclaration) type;
                parseType(type, declaration);
            }
        }
    }

    private void parseType(TypeDeclaration<?> type, ClassOrInterfaceDeclaration declaration) {
        if (Util.hasAnnotation(declaration, "Api")) {
            String pack = unit.getPackageDeclaration().get().toString();
            String apiName = pack.substring(8, pack.length() - 3) + "." + type.getNameAsString();
            for (BodyDeclaration<?> member : declaration.getMembers()) {
                if (member instanceof MethodDeclaration) {
                    parseApiMethod(member, apiName);
                }
            }
        }
    }

    private void parseApiMethod(BodyDeclaration member, String apiName) {
        String name = "ApiMethod";
        Map<String, String> params = Util.getAnnotationParam(member, name);
        if (params != null) {

        }
    }
/*
            ApiParser apiParser = new ApiParser(file);

            FieldDeclaration fieldDeclaration = (FieldDeclaration) (new ApiParser(file)).unit.getTypes().get(0).getMembers().get(0);
            VariableDeclarator type = fieldDeclaration.getVariables().get(0);
            Object f = JavaParserFacade.get(typeSolver).getType(type);
            ResolvedType rf = ( JavaParserFacade.get(typeSolver).getType(type));
            ResolvedReferenceType r= rf.asReferenceType();
            r.getQualifiedName();
*/

}
