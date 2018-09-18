package com.sbrf.meta.plugin.dto.api;

import org.json.JSONArray;

import java.util.HashMap;
import java.util.Map;

public class ApiStorage {
    //Api class - Api info
    private Map<String, ApiInfo> apiMap = new HashMap<>();
    //Api Request Class - ApiInfo
    private Map<String, ApiInfo> apiRequestMap = new HashMap<>();

    public void addApi(String apiClass, String methodName, String desc, String name, String version) {
        ApiInfo apiInfo = this.apiMap.get(apiClass);
        if (apiInfo == null) {
            apiInfo = new ApiInfo(apiClass);
            this.apiMap.put(apiInfo.apiClass, apiInfo);
        }
        apiInfo.addMethod(methodName, desc, name, version);
    }

    public boolean containsApi(String api) {
        return apiMap.containsKey(api);
    }

    public void addApiImpl(String apiClass, String implClass) {
        this.apiMap.get(apiClass).addImpl(implClass);
    }

    public void addRequest(String apiClass, String apiRequestClass) {
        ApiInfo apiInfo = this.apiMap.get(apiClass);
        apiInfo.addRequest(apiRequestClass);
        this.apiRequestMap.put(apiRequestClass, apiInfo);
    }

    public void addCall(String apiClass, String className, String method, String desc) {
        ApiInfo apiInfo = this.apiMap.get(apiClass);
        apiInfo.addCall(className, method, desc);
    }

    public boolean containsApiRequest(String apiRequestClass) {
        return apiRequestMap.containsKey(apiRequestClass);
    }

    public String getApiByRequest(String apiRequestClass) {
        return apiRequestMap.get(apiRequestClass).apiClass;
    }

    public JSONArray toJson() {
        JSONArray result = new JSONArray();
        for (ApiInfo apiInfo : apiMap.values()) {
            result.put(apiInfo.toJson());
        }
        return result;
    }

}
