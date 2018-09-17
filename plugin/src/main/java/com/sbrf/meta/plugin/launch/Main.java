package com.sbrf.meta.plugin.launch;

import com.sbrf.meta.plugin.Parser;

import java.io.File;
import java.util.Collections;

public class Main {
    public static void main(String... args) {
        File jar = new File("/Users/intet/sbrf/meta/plugin/sample/target/sample-1.0-SNAPSHOT.jar");
        File source = new File("/Users/intet/sbrf/meta/plugin/sample/src/main/java/com/sbrf/meta/sample/api/SomeService.java");
        Parser.parse(Collections.singleton(jar), Collections.singleton(source));
    }
}
