package com.sbrf.meta.plugin;

import com.sbrf.meta.plugin.asm.AsmParser;
import com.sbrf.meta.plugin.dto.api.ApiStorage;
import com.sbrf.meta.plugin.dto.api.GAV;
import com.sbrf.meta.plugin.github.SourceParser;

import java.io.File;
import java.util.Collection;
import java.util.Map;

public class Parser {


    public static ApiStorage parse(Map<GAV, File> jars, Collection<File> javaSource, Collection<File> jarSource) {
        AsmParser jarParser = new AsmParser(jars);
        ApiStorage storage = jarParser.parse();
        if (false)
            SourceParser.parse(javaSource, jarSource, jars, storage);
        return storage;
    }
}
