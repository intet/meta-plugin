package com.sbrf.meta.plugin.dto.api;

public class ApiMethodInfo {
    public final String methodName;
    public final String signature;

    public ApiMethodInfo(String methodName, String signature) {
        this.methodName = methodName;
        this.signature = signature;
    }
}
