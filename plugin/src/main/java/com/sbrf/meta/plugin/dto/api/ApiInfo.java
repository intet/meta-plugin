package com.sbrf.meta.plugin.dto.api;

import com.sbrf.meta.plugin.asm.util.ParserUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.*;

public class ApiInfo {
    public final String apiClass;
    public final GAV gav;
    public final Set<String> apiRequestClass = new HashSet<>();
    public final Set<ApiImpl> impls = new HashSet<>();
    public final Map<String, ApiMethodInfo> methods = new HashMap<>();


    public ApiInfo(String apiClass, GAV gav) {
        this.apiClass = apiClass;
        this.gav = gav;
    }

    public void addMethod(String methodName, String desc, String name, String version, List<Dto> dto, Dto result) {
        this.methods.put(ParserUtils.getMethodSignature(methodName, desc),
                new ApiMethodInfo(methodName, desc, name, version, dto, result));
    }

    public void addImpl(String implClass, GAV gav) {
        this.impls.add(new ApiImpl(implClass, gav));
    }

    public void addRequest(String apiRequestClass) {
        this.apiRequestClass.add(apiRequestClass);
    }

    public void addCall(String className, GAV gav, String methodName, String desc) {
        ApiMethodInfo methodInfo = this.methods.get(ParserUtils.getMethodSignature(methodName, desc));
        methodInfo.addCall(className, gav);
    }

    public JSONObject toJson() {
        JSONObject result = new JSONObject();
        result.put("class", apiClass);
        result.put("gav", gav.toJson());
        JSONArray implArray = new JSONArray();
        for (ApiImpl impl : impls) {
            implArray.put(impl.toJson());
        }
        result.put("implementation", implArray);

        JSONArray methodArray = new JSONArray();
        for (ApiMethodInfo method : methods.values()) {
            methodArray.put(method.toJson());
        }
        result.put("methods", methodArray);
        return result;
    }

    public void addComment(String method, String comment) {
        ApiMethodInfo methodInfo = this.methods.get(method);
        if (methodInfo == null) return;
        methodInfo.addComment(comment);
    }
}
