package com.sbrf.meta.plugin.launch;

import com.sbrf.meta.plugin.Parser;
import com.sbrf.meta.plugin.dto.api.ApiStorage;

import java.io.File;
import java.util.Collections;

public class Main {
    public static void main(String... args) {
        File jar = new File("C:\\Users\\Sivodedov-DA\\.m2\\repository\\org\\projectlombok\\lombok\\1.16.16\\lombok-1.16.16.jar");
        File source = new File("/Users/intet/sbrf/meta/plugin/sample/src/main/java/com/sbrf/meta/sample/api/SomeService.java");
        ApiStorage storage = Parser.parse(Collections.singleton(jar), Collections.singleton(source));
        System.out.println(storage.toJson());
    }
}
