package com.sbrf.meta.plugin;

import com.sbrf.meta.plugin.asm.AsmParser;
import com.sbrf.meta.plugin.dto.api.ApiStorage;
import com.sbrf.meta.plugin.github.SourceParser;

import java.io.File;
import java.util.Collection;

public class Parser {


    public static ApiStorage parse(Collection<File> jars, Collection<File> files) {
        AsmParser jarParser = new AsmParser(jars);
        ApiStorage storage = jarParser.parse();
        SourceParser.parse(files, storage);
        return storage;
    }
}
