package com.sbrf.meta.plugin.asm.util;


import org.apache.commons.io.IOUtils;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.tree.ClassNode;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.stream.Stream;

public class ParserUtils {

    static Map<String, ClassNode> loadClasses(File jarFile) throws IOException {
        return loadClasses(Collections.singleton(jarFile));
    }
    public static Map<String, ClassNode> loadClasses(Collection<File> jarFiles){
        Map<String, ClassNode> classes = new HashMap<String, ClassNode>();
        jarFiles.stream().forEach(jarFile-> readJar(classes, jarFile));
        return classes;
    }

    private static void readJar(Map<String, ClassNode> classes, File jarFile) {
        try {
        JarFile jar = new JarFile(jarFile);
        Stream<JarEntry> str = jar.stream();
        str.forEach(z -> readJar(jar, z, classes));
        jar.close();
        }
        catch (IOException ex){
            throw new RuntimeException(ex.getMessage(), ex);
        }
    }


    static Map<String, ClassNode> readJar(JarFile jar, JarEntry entry, Map<String, ClassNode> classes) {
        String name = entry.getName();
        try (InputStream jis = jar.getInputStream(entry)){
            if (name.endsWith(".class")) {
                byte[] bytes = IOUtils.toByteArray(jis);
                String cafebabe = String.format("%02X%02X%02X%02X", bytes[0], bytes[1], bytes[2], bytes[3]);
                if (!cafebabe.toLowerCase().equals("cafebabe")) {
                    // This class doesn't have a valid magic
                    return classes;
                }
                try {
                    ClassNode cn = getNode(bytes);
                    classes.put(cn.name, cn);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return classes;
    }

    static ClassNode getNode(byte[] bytes) {
        ClassReader cr = new ClassReader(bytes);
        ClassNode cn = new ClassNode();
        try {
            cr.accept(cn, ClassReader.EXPAND_FRAMES);
        } catch (Exception e) {
            e.printStackTrace();
        }
        cr = null;
        return cn;
    }

    public static String getMethodSignature(String method, String desc) {
        return method + desc.substring(desc.indexOf("("), desc.indexOf(")") + 1);
    }
}
