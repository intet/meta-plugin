package com.sbrf.meta.plugin.dto.api;

import org.json.JSONArray;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApiStorage {
    //Api class - Api info
    private Map<String, ApiInfo> apiMap = new HashMap<>();
    //Api Request Class - ApiInfo
    private Map<String, ApiInfo> apiRequestMap = new HashMap<>();

    public void addApi(String apiClass, String methodName, String desc, GAV gav, String name, String version, List<Dto> dto, Dto result) {
        ApiInfo apiInfo = this.apiMap.get(apiClass);
        if (apiInfo == null) {
            apiInfo = new ApiInfo(apiClass, gav);
            this.apiMap.put(apiInfo.apiClass, apiInfo);
        }
        apiInfo.addMethod(methodName, desc, name, version, dto, result);
    }

    public boolean containsApi(String api) {
        return apiMap.containsKey(api);
    }

    public void addApiImpl(String apiClass, String implClass, GAV gav) {
        this.apiMap.get(apiClass).addImpl(implClass, gav);
    }

    public void addRequest(String apiClass, String apiRequestClass) {
        ApiInfo apiInfo = this.apiMap.get(apiClass);
        apiInfo.addRequest(apiRequestClass);
        this.apiRequestMap.put(apiRequestClass, apiInfo);
    }

    public void addCall(String apiClass, String className, GAV gav, String method, String desc) {
        ApiInfo apiInfo = this.apiMap.get(apiClass);
        apiInfo.addCall(className, gav, method, desc);
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
