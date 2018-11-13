package com.sbrf.meta.plugin.dto.api;

import com.sbrf.meta.plugin.dto.xml.ImplementationType;
import org.json.JSONObject;

import java.util.Objects;

public class ApiImpl {
    public final String className;
    public final GAV gav;

    public ApiImpl(String className, GAV gav) {
        this.className = className;
        this.gav = gav;
    }

    public JSONObject toJson() {
        JSONObject result = new JSONObject();
        result.put("class", className);
        result.put("gav", gav.toJson());
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApiCall call = (ApiCall) o;
        return Objects.equals(className, call.className) &&
                Objects.equals(gav, call.gav);
    }

    @Override
    public int hashCode() {
        return Objects.hash(className, gav);
    }

    public ImplementationType toXml() {
        ImplementationType result = new ImplementationType();
        result.setClazz(className);
        result.setGav(gav.toXml());
        return result;
    }
}
