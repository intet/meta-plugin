package com.sbrf.meta.plugin.github;

import com.sbrf.meta.plugin.dto.api.ApiStorage;
import com.sbrf.meta.plugin.github.parser.ApiParser;

import java.io.File;
import java.util.Collection;

public class SourceParser {


    public static ApiStorage parse(Collection<File> files, ApiStorage storage){
        if(storage == null){
            storage = new ApiStorage();
        }
        for(File file:files){
            ApiParser apiParser = new ApiParser(file);
            apiParser.parse(storage);
        }

        return storage;
    }
}
