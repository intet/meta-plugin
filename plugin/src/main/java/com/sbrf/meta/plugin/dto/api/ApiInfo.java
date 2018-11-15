package com.sbrf.meta.plugin.dto.api;

import com.sbrf.meta.plugin.asm.util.ParserUtils;
import com.sbrf.meta.plugin.dto.ufs.APIType;
import com.sbrf.meta.plugin.dto.ufs.ApiTypeType;
import com.sbrf.meta.plugin.dto.xml.ApiDeclarationType;
import com.sbrf.meta.plugin.dto.xml.ApiImplementationType;
import com.sbrf.meta.plugin.dto.xml.ApiInvocationType;
import com.sbrf.meta.plugin.dto.xml.ModuleType;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.*;

import static com.sbrf.meta.plugin.asm.util.DtoUtils.addDependencies;
import static com.sbrf.meta.plugin.asm.util.DtoUtils.getModule;

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

    public void addMethod(String logicalName, String technicalName, String desc, String version,
                          List<String> input, String output, List<String> throwsList) {
        this.methods.put(ParserUtils.getMethodSignature(technicalName, desc),
                new ApiMethodInfo(logicalName, technicalName, desc, version, input, output, throwsList));
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


    public void addParamsName(String method, List<String> paramsName) {
        ApiMethodInfo methodInfo = this.methods.get(method);
        if (methodInfo == null) return;
        methodInfo.addParamsName(paramsName);
    }

    public void addComment(String method, String comment) {
        ApiMethodInfo methodInfo = this.methods.get(method);
        if (methodInfo == null) return;
        methodInfo.addComment(comment);
    }

    public void toModule(Map<GAV, ModuleType> moduleMap, Map<String, Dto> dtoMap, Map<GAV, Set<GAV>> dependencyMap) {
        ApiDeclarationType declarationType = new ApiDeclarationType();
        declarationType.setClazz(apiClass);
        declarationType.setGav(gav.toXml());
        for (ApiMethodInfo method : methods.values()) {
            declarationType.getMethod().add(method.toXml());
            addDependencies(gav, dtoMap, dependencyMap, method.output);
            for (String input : method.input) {
                addDependencies(gav, dtoMap, dependencyMap, input);
            }

            for (ApiCall call : method.invocations) {
                ApiInvocationType apiCall = new ApiInvocationType();
                apiCall.setApiClass(apiClass);
                apiCall.setClazz(call.className);
                apiCall.setGav(call.gav.toXml());
                getModule(moduleMap, call.gav).getApiInvocationType().add(apiCall);
            }
        }
        getModule(moduleMap, gav).getApiDeclaration().add(declarationType);

        for (ApiImpl impl : impls) {
            ApiImplementationType implementationType = new ApiImplementationType();
            implementationType.setApiClass(apiClass);
            implementationType.setClazz(impl.className);
            implementationType.setGav(impl.gav.toXml());
            getModule(moduleMap, impl.gav).getApiImplementation().add(implementationType);
        }
    }

    public APIType toUfs() {
        APIType type = new APIType();
        type.setId(apiClass);
        type.setLogicalName(apiClass);
        type.setTechnicalName(apiClass);
        type.setApiType(ApiTypeType.JAVA);
        for (ApiMethodInfo methodInfo : methods.values()) {
            type.getVersions().add(methodInfo.toUfs(this));
        }
        return type;
    }
}
