package com.sbrf.meta.plugin.dto.api;

import com.sbrf.meta.plugin.asm.util.DtoUtils;
import com.sbrf.meta.plugin.dto.ufs.UfsCandidateApiImportRqType;
import com.sbrf.meta.plugin.dto.xml.ModuleType;
import com.sbrf.meta.plugin.dto.xml.Root;
import org.json.JSONObject;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    public String toXml() {
        Map<GAV, ModuleType> moduleMap = new HashMap<>();
        Map<GAV, Set<GAV>> dependencyMap = new HashMap<>();
        for (ApiInfo apiInfo : apiMap.values()) {
            apiInfo.toModule(moduleMap, dtoMap, dependencyMap);
        }
        for (Dto dto : dtoMap.values()) {
            dto.toModule(moduleMap, dtoMap, dependencyMap);
        }
        for (Map.Entry<GAV, Set<GAV>> entry : dependencyMap.entrySet()) {
            ModuleType module = DtoUtils.getModule(moduleMap, entry.getKey());
            for (GAV dependency : entry.getValue()) {
                module.getDependencies().add(dependency.toXml());
            }
        }
        Root root = new Root();
        for (ModuleType module : moduleMap.values()) {
            root.getModule().add(module);
        }
        return getString(root);
    }

    public void addComment(String api, String method, String comment) {
        ApiInfo apiInfo = this.apiMap.get(api);
        if (apiInfo == null)
            return;
        apiInfo.addComment(method, "/**" + comment + "*/");
    }

    public void addParamsName(String api, String method, List<String> paramsName) {
        ApiInfo apiInfo = this.apiMap.get(api);
        if (apiInfo == null)
            return;
        apiInfo.addParamsName(method, paramsName);
    }

    private String getString(Root xml) {
        try {
            JAXBContext context = JAXBContext.newInstance(Root.class);
            Marshaller marshaller = context.createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(xml, sw);
            return sw.toString();

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return "";
    }

    public boolean hasDto(String className) {
        return dtoMap.containsKey(className);
    }

    public void addDto(String className, Dto dto) {
        dtoMap.put(className, dto);
    }

    public void toUfs() {
        UfsCandidateApiImportRqType rqType = new UfsCandidateApiImportRqType();
        for (ApiInfo apiInfo : apiMap.values()) {
            rqType.getApiList().add(apiInfo.toUfs());

        }
    }
}
