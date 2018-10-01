package com.sbrf.meta.plugin.github;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;
import com.github.javaparser.symbolsolver.resolution.typesolvers.CombinedTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.JarTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.ReflectionTypeSolver;
import com.sbrf.meta.plugin.dto.api.ApiStorage;
import com.sbrf.meta.plugin.dto.api.GAV;
import com.sbrf.meta.plugin.github.parser.ApiParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class SourceParser {


    public static ApiStorage parse(Collection<File> javaSource, Collection<File> jarSource, Map<GAV, File> jars, ApiStorage storage) {
        JavaParserFacade facade = getTypeSolver(jars);
        parseSource(javaSource, storage, facade);
        parseJar(jarSource, storage, facade);
        return storage;
    }


    private static JavaParserFacade getTypeSolver(Map<GAV, File> jars) {
        CombinedTypeSolver combinedTypeSolver = new CombinedTypeSolver();
        combinedTypeSolver.add(new ReflectionTypeSolver());
        for (File f : jars.values()) {
            try {
                combinedTypeSolver.add(new JarTypeSolver(f));
            } catch (IOException e) {
                throw new RuntimeException(e.getMessage(), e);
            }
        }
        return JavaParserFacade.get(combinedTypeSolver);
    }

    private static void parseSource(Collection<File> javaSource, ApiStorage storage, JavaParserFacade facade) {
        for (File file : javaSource) {
            CompilationUnit unit;
            try {
                unit = JavaParser.parse(file);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e.getMessage(), e);
            }
            ApiParser parser = new ApiParser(unit, facade, storage);
            parser.parse();
        }
    }

    private static void parseJar(Collection<File> javaSource, ApiStorage storage, JavaParserFacade facade) {
        for (File jarFile : javaSource) {
            try {
                ZipFile jar = new ZipFile(jarFile);
                Stream<? extends ZipEntry> str = jar.stream();
                str.forEach(z -> readJar(jar, z, storage, facade));
                jar.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex.getMessage(), ex);
            }
        }
    }

    private static void readJar(ZipFile jar, ZipEntry entry, ApiStorage storage, JavaParserFacade facade) {
        String name = entry.getName();
        try (InputStream jis = jar.getInputStream(entry)) {
            if (!name.endsWith(".java")) return;
            CompilationUnit unit = JavaParser.parse(jis);
            ApiParser parser = new ApiParser(unit, facade, storage);
            parser.parse();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
