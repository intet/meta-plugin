package com.sbrf.meta.plugin;

import com.sbrf.meta.plugin.asm.AsmParser;
import com.sbrf.meta.plugin.dto.api.ApiStorage;
import com.sbrf.meta.plugin.dto.api.GAV;
import com.sbrf.meta.plugin.github.SourceParser;

import java.io.File;
import java.util.Collection;
import java.util.Map;

public class Parser {

    /**
     * @param jars       jar с бинарниками
     * @param javaSource java class с исходными кодами, которые лежат в текущем проекте
     * @param jarSource  jar с исходиниками для всех проектов кроме текущего
     * @return Storage где лежит результат работы парсеров
     */
    public static ApiStorage parse(Map<GAV, File> jars, Collection<File> javaSource, Collection<File> jarSource) {
        AsmParser jarParser = new AsmParser(jars);
        ApiStorage storage = jarParser.parse();
        SourceParser.parse(javaSource, jarSource, jars, storage);
        return storage;
    }
}
