package com.sbrf.meta.plugin.dto.api;

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

    public void addMethod(String methodName, String desc) {
        this.methods.put(methodName + desc, new ApiMethodInfo(methodName, desc));
    }

    public void addImpl(String implClass) {
        this.impls.add(implClass);
    }

    public void addRequest(String apiRequestClass) {
        this.apiRequestClass.add(apiRequestClass);
    }
}
