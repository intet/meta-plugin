package com.sbrf.meta.plugin.dto.api;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashSet;
import java.util.Set;

public class ApiMethodInfo {
    public final String methodName;
    public final String signature;
    public final String name;
    public final String version;
    public final Set<String> calls = new HashSet<>();

    public ApiMethodInfo(String methodName, String signature, String name, String version) {
        this.methodName = methodName;
        this.signature = signature;
        this.name = name;
        this.version = version;
    }

    public void addCall(String className) {
        calls.add(className);
    }

    public JSONObject toJson() {
        JSONObject result = new JSONObject();
        result.put("method", methodName);
        result.put("name", name);
        result.put("version", version);
        result.put("signature", signature);
        JSONArray callArray = new JSONArray();
        for (String className : calls) {
            callArray.put(className);
        }
        result.put("call", callArray);
        return result;
    }

}
