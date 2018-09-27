package com.sbrf.meta.plugin.dto.api;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ApiMethodInfo {
    public final String methodName;
    public final String signature;
    public final String name;
    public final String version;
    public final List<Dto> dto;
    public final Dto result;
    public final Set<String> calls = new HashSet<>();

    public ApiMethodInfo(String methodName, String signature, String name, String version, List<Dto> dto, Dto result) {
        this.methodName = methodName;
        this.signature = signature;
        this.name = name;
        this.version = version;
        this.dto = dto;
        this.result = result;
    }

    public void addCall(String className) {
        calls.add(className);
    }

    public JSONObject toJson() {
        JSONObject result = new JSONObject();
        result.put("method", methodName);
        result.put("name", name);
        result.put("version", version);
        JSONArray dtoArray = new JSONArray();
        for (Dto className : dto) {
            dtoArray.put(className.toJson());
        }
        result.put("signature", dtoArray);
        result.put("result", this.result.toJson());
        JSONArray callArray = new JSONArray();
        for (String className : calls) {
            callArray.put(className.replace('/', '.'));
        }
        result.put("call", callArray);
        return result;
    }

}
