package com.sbrf.meta.plugin.dto.api;

import com.sbrf.meta.plugin.asm.util.ParserUtils;
import com.sbrf.meta.plugin.dto.xml.ApiType;
import com.sbrf.meta.plugin.dto.xml.ImplementationsType;
import com.sbrf.meta.plugin.dto.xml.MethodsType;
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

    public void addComment(String method, String comment) {
        ApiMethodInfo methodInfo = this.methods.get(method);
        if (methodInfo == null) return;
        methodInfo.addComment(comment);
    }

    public ApiType toXml() {
        ApiType result = new ApiType();
        result.setClazz(apiClass);
        result.setGav(gav.toXml());
        ImplementationsType implArray = new ImplementationsType();
        for (ApiImpl impl : impls) {
            implArray.getImplementation().add(impl.toXml());
        }
        result.setImplementations(implArray);

        MethodsType methodArray = new MethodsType();
        for (ApiMethodInfo method : methods.values()) {
            methodArray.getMethod().add(method.toXml());
        }
        result.setMethods(methodArray);
        return result;

    }
}
