package com.sbrf.meta.plugin.asm;

import com.sbrf.meta.plugin.asm.parser.ApiCallParser;
import com.sbrf.meta.plugin.asm.parser.ApiImplParser;
import com.sbrf.meta.plugin.asm.parser.ApiParser;
import com.sbrf.meta.plugin.asm.parser.ApiRequestParser;
import com.sbrf.meta.plugin.asm.util.ParserUtils;
import com.sbrf.meta.plugin.dto.api.ApiStorage;
import com.sbrf.meta.plugin.dto.api.GAV;
import org.objectweb.asm.tree.ClassNode;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class AsmParser {
    private final Map<String, ClassNode> nodes;
    private final Map<String, GAV> metaInfo;


    public AsmParser(Map<GAV, File> jars) {
        this.nodes = new HashMap<>();
        this.metaInfo = new HashMap<>();
        for (Map.Entry<GAV, File> entry : jars.entrySet()) {
            ParserUtils.readJar(entry.getValue(), entry.getKey(), nodes, metaInfo);
        }
    }


    public ApiStorage parse() {
        ApiStorage storage = ApiParser.findApi(nodes, metaInfo);
        ApiImplParser.findApiImpl(nodes, metaInfo, storage);
        ApiRequestParser.findApiRequests(nodes, storage);
        ApiCallParser.findCall(nodes, metaInfo, storage);
        return storage;
    }
}
