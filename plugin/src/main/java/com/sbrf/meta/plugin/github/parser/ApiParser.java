package com.sbrf.meta.plugin.github.parser;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.*;
import com.github.javaparser.resolution.declarations.ResolvedReferenceTypeDeclaration;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;
import com.sbrf.meta.plugin.dto.api.ApiStorage;

import java.util.ArrayList;
import java.util.List;

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
                parseType(declaration);
            }
        }
    }

    private void parseType(ClassOrInterfaceDeclaration declaration) {
        if (Util.hasAnnotation(declaration, "Api")) {
            ResolvedReferenceTypeDeclaration typeDeclaration = facade.getTypeDeclaration(declaration);
            String apiName = typeDeclaration.getQualifiedName();

            for (BodyDeclaration<?> member : declaration.getMembers()) {
                if (member instanceof MethodDeclaration) {
                    parseApiMethod((MethodDeclaration) member, apiName);
                }
            }

        }
    }

    private void parseApiMethod(MethodDeclaration methodDeclaration, String apiName) {
        String desc = Util.getMethodSignature(methodDeclaration.getName(), methodDeclaration.getParameters(), facade);
        List<String> paramsName = new ArrayList<>();
        if (methodDeclaration.getParameters() != null) {
            for (Parameter param : methodDeclaration.getParameters()) {
                paramsName.add(param.getNameAsString());
            }
            storage.addParamsName(apiName, desc, paramsName);
        }


        methodDeclaration.getComment().ifPresent(comment -> storage.addComment(apiName, desc, comment.getContent()));

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
