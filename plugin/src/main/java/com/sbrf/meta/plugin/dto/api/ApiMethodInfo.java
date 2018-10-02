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
    public final Set<ApiCall> calls = new HashSet<>();
    private String comment;

    public ApiMethodInfo(String methodName, String signature, String name, String version, List<Dto> dto, Dto result) {
        this.methodName = methodName;
        this.signature = signature;
        this.name = name;
        this.version = version;
        this.dto = dto;
        this.result = result;
    }

    public void addCall(String className, GAV gav) {
        calls.add(new ApiCall(className, gav));
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
        for (ApiCall call : calls) {
            callArray.put(call.toJson());
        }
        result.put("call", callArray);
        result.put("comment", comment);
        return result;
    }

    public void addComment(String comment) {
        this.comment = comment;
    }
}
