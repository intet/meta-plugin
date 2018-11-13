package com.sbrf.meta.plugin.dto.api;

import com.sbrf.meta.plugin.dto.xml.ApisType;
import com.sbrf.meta.plugin.dto.xml.DtosType;
import com.sbrf.meta.plugin.dto.xml.RootType;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApiStorage {
    //Api class - Api info
    private Map<String, ApiInfo> apiMap = new HashMap<>();
    //Api Request Class - ApiInfo
    private Map<String, ApiInfo> apiRequestMap = new HashMap<>();
    private Map<String, Dto> dtoMap = new HashMap<>();

    public void addApi(String apiClass, String logicalName, String technicalName, String desc, GAV gav, String version,
                       List<String> input, String output, List<String> throwsList) {
        ApiInfo apiInfo = this.apiMap.get(apiClass);
        if (apiInfo == null) {
            apiInfo = new ApiInfo(apiClass, gav);
            this.apiMap.put(apiInfo.apiClass, apiInfo);
        }
        apiInfo.addMethod(logicalName, technicalName, desc, version, input, output, throwsList);
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

    public JSONObject toJson() {
        JSONObject result = new JSONObject();
        JSONObject api = new JSONObject();
        for (ApiInfo apiInfo : apiMap.values()) {
            api.put(apiInfo.apiClass, apiInfo.toJson());
        }
        result.put("api", api);
        JSONObject dto = new JSONObject();

        for (Map.Entry<String, Dto> entry : dtoMap.entrySet()) {
            dto.put(entry.getKey(), entry.getValue().toJson());
        }
        result.put("dto", dto);
        return result;
    }

    public RootType toXml() {
        RootType result = new RootType();
        ApisType api = new ApisType();
        for (ApiInfo apiInfo : apiMap.values()) {
            api.getApi().add(apiInfo.toXml());
        }
        result.setApis(api);


        DtosType dto = new DtosType();
        for (Map.Entry<String, Dto> entry : dtoMap.entrySet()) {
            dto.getDto().add(entry.getValue().toXml());
        }
        result.setDtos(dto);
        return result;
    }
    public void addComment(String api, String method, String comment) {
        ApiInfo apiInfo = this.apiMap.get(api);
        if (apiInfo == null)
            return;
        apiInfo.addComment(method, "/**" + comment + "*/");
    }

    public boolean hasDto(String className) {
        return dtoMap.containsKey(className);
    }

    public void addDto(String className, Dto dto) {
        dtoMap.put(className, dto);
    }
}
