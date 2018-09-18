package com.sbrf.meta.plugin.dto.api;

import com.sbrf.meta.plugin.asm.util.ParserUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ApiInfo {
    public final String apiClass;
    public final Set<String> apiRequestClass = new HashSet<>();
    public final Set<String> impls = new HashSet<>();
    public final Map<String, ApiMethodInfo> methods = new HashMap<>();

    public ApiInfo(String apiClass) {
        this.apiClass = apiClass;
    }

    public void addMethod(String methodName, String desc, String name, String version) {
        this.methods.put(ParserUtils.getMethodSignature(methodName, desc), new ApiMethodInfo(methodName, desc, name, version));
    }

    public void addImpl(String implClass) {
        this.impls.add(implClass);
    }

    public void addRequest(String apiRequestClass) {
        this.apiRequestClass.add(apiRequestClass);
    }

    public void addCall(String className, String methodName, String desc) {
        ApiMethodInfo methodInfo = this.methods.get(ParserUtils.getMethodSignature(methodName, desc));
        methodInfo.addCall(className);
    }

    public JSONObject toJson() {
        JSONObject result = new JSONObject();
        result.put("class", apiClass);
        JSONArray implArray = new JSONArray();
        for (String impl : impls) {
            implArray.put(impl);
        }
        result.put("implementation", implArray);

        JSONArray methodArray = new JSONArray();
        for (ApiMethodInfo method : methods.values()) {
            methodArray.put(method.toJson());
        }
        result.put("methods", methodArray);
        return result;
    }

}
