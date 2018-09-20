package com.sbrf.meta.plugin.launch;

import com.sbrf.meta.plugin.Parser;
import com.sbrf.meta.plugin.dto.api.ApiStorage;

import java.io.File;
import java.util.Collections;

public class Main {
    public static void main(String... args) {
        File jar = new File("D:\\project\\pprb_cx_mut\\cx-mut-api-cep\\target\\cx-mut-api-cep-2.3.51-SNAPSHOT.jar");
        File source = new File("/Users/intet/sbrf/meta/plugin/sample/src/main/java/com/sbrf/meta/sample/api/SomeService.java");
        ApiStorage storage = Parser.parse(Collections.singleton(jar), Collections.singleton(source));
        System.out.println(storage.toJson());
    }
}
