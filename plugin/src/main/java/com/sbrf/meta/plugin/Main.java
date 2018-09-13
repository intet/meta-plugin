package com.sbrf.meta.plugin;

import com.sbrf.meta.plugin.asm.AsmParser;

import java.io.File;
import java.util.Collections;

public class Main {
    public static void main(String... args) {
        File file = new File("/Users/intet/sbrf/meta/plugin/sample/target/sample-1.0-SNAPSHOT.jar");
        AsmParser parser = new AsmParser(Collections.singleton(file));
        parser.parse();
    }
}
