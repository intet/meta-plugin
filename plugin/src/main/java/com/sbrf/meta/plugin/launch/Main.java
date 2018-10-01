package com.sbrf.meta.plugin.launch;

import com.sbrf.meta.plugin.Parser;
import com.sbrf.meta.plugin.dto.api.ApiStorage;
import com.sbrf.meta.plugin.dto.api.GAV;

import java.io.File;
import java.nio.file.Paths;
import java.util.Collections;

public class Main {
    public static void main(String... args) {
        File jar = new File(Paths.get("").toAbsolutePath()+"/sample/target/sample-1.0-SNAPSHOT.jar");
        File source = new File("/Users/intet/sbrf/meta/plugin/sample/src/main/java/com/sbrf/meta/sample/api/SomeService.java");
        ApiStorage storage = Parser.parse(Collections.singletonMap(new GAV("com.sbrf.meta", "plugin", "0.1"), jar),
                Collections.EMPTY_LIST, Collections.singleton(source));
        System.out.println(storage.toJson());
    }
}
