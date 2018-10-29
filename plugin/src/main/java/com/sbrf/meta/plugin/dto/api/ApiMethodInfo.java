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
    public final List<String> input;
    public final List<String> throwsList;
    public final String output;
    public final Set<ApiCall> invocations = new HashSet<>();
    private String comment;

    public ApiMethodInfo(String methodName, String signature, String name, String version,
                         List<String> input, String output, List<String> throwsList) {
        this.methodName = methodName;
        this.signature = signature;
        this.name = name;
        this.version = version;
        this.input = input;
        this.output = output;
        this.throwsList = throwsList;
    }

    public void addCall(String className, GAV gav) {
        invocations.add(new ApiCall(className, gav));
    }

    public JSONObject toJson() {
        JSONObject result = new JSONObject();
        result.put("method", methodName);
        result.put("name", name);
        result.put("version", version);
        JSONArray inputArray = new JSONArray();
        for (String className : input) {
            inputArray.put(className);
        }
        result.put("input", inputArray);
        JSONArray throwsArray = new JSONArray();
        for (String throwItem : throwsList) {
            throwsArray.put(throwItem);
        }
        result.put("throws", throwsArray);
        result.put("output", this.output);
        JSONArray callArray = new JSONArray();
        for (ApiCall call : invocations) {
            callArray.put(call.toJson());
        }
        result.put("invocations", callArray);
        result.put("comment", comment);
        return result;
    }

    public void addComment(String comment) {
        this.comment = comment;
    }
}
