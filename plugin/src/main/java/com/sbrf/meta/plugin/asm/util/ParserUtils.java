package com.sbrf.meta.plugin.asm.util;


import com.sbrf.meta.plugin.dto.api.GAV;
import org.apache.commons.io.IOUtils;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.tree.ClassNode;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.stream.Stream;

public class ParserUtils {

    public static void readJar(File jarFile, GAV gav, Map<String, ClassNode> classes, Map<String, GAV> metaInfo) {
        try {
            JarFile jar = new JarFile(jarFile);
            try {
                String system = jar.getManifest().getMainAttributes().getValue("system");
                if (system != null) {
                    gav.system = system;
                }
                String component = jar.getManifest().getMainAttributes().getValue("component");
                if (component != null) {
                    gav.component = component;
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            Stream<JarEntry> str = jar.stream();
            str.forEach(z -> readJar(jar, z, gav, classes, metaInfo));
            jar.close();
        } catch (IOException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        }
    }


    static Map<String, ClassNode> readJar(JarFile jar, JarEntry entry, GAV gav, Map<String, ClassNode> classes, Map<String, GAV> metaInfo) {
        String name = entry.getName();
        try (InputStream jis = jar.getInputStream(entry)) {
            if (name.endsWith(".class")) {
                byte[] bytes = IOUtils.toByteArray(jis);
                String cafebabe = String.format("%02X%02X%02X%02X", bytes[0], bytes[1], bytes[2], bytes[3]);
                if (!cafebabe.toLowerCase().equals("cafebabe")) {
                    // This class doesn't have a valid magic
                    return classes;
                }
                try {
                    ClassNode cn = getNode(bytes);
                    cn.name = cn.name.replace('/', '.');
                    cn.superName = cn.superName.replace('/', '.');
                    if (cn.interfaces != null) {
                        for (int i = 0; i < cn.interfaces.size(); i++) {
                            cn.interfaces.set(i, cn.interfaces.get(i).replace('/', '.'));
                        }
                    }
                    classes.put(cn.name, cn);
                    metaInfo.put(cn.name, gav);
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
