package com.sbrf.meta.plugin.asm;

import com.sbrf.meta.plugin.dto.api.ApiStorage;
import com.sbrf.meta.plugin.asm.parser.ApiCallParser;
import com.sbrf.meta.plugin.asm.parser.ApiImplParser;
import com.sbrf.meta.plugin.asm.parser.ApiParser;
import com.sbrf.meta.plugin.asm.parser.ApiRequestParser;
import com.sbrf.meta.plugin.asm.util.ParserUtils;
import org.objectweb.asm.tree.ClassNode;

import java.io.File;
import java.util.Collection;
import java.util.Map;

public class AsmParser {
    private final Map<String, ClassNode> nodes;


    public AsmParser(Collection<File> jars) {
        this.nodes = ParserUtils.loadClasses(jars);
    }

    public ApiStorage parse() {
        ApiStorage storage = ApiParser.findApi(nodes);
        ApiImplParser.findApiImpl(nodes, storage);
        ApiRequestParser.findApiRequests(nodes, storage);
        ApiCallParser.findCall(nodes, storage);
        return storage;
    }
}
