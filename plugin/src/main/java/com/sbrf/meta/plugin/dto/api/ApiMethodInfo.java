package com.sbrf.meta.plugin.dto.api;

import java.util.HashSet;
import java.util.Set;

public class ApiMethodInfo {
    public final String methodName;
    public final String signature;
    public final String name;
    public final String version;
    public final Set<String> calls = new HashSet<>();

    public ApiMethodInfo(String methodName, String signature, String name, String version) {
        this.methodName = methodName;
        this.signature = signature;
        this.name = name;
        this.version = version;
    }

    public void toJson() {
        for (String className : calls) {

        }
    }

    public void addCall(String className) {
        calls.add(className);
    }
}
