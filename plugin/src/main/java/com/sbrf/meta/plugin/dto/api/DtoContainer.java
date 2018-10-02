package com.sbrf.meta.plugin.dto.api;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Collection;

public class DtoContainer extends Dto {
    public final Collection<Dto> elements;

    public DtoContainer(String containerClass, Collection<Dto> elements, boolean extend) {
        super(containerClass, extend);
        this.elements = elements;
    }

    public JSONObject toJson() {
        JSONObject result = new JSONObject();
        result.put("container", dtoClass.replace('/', '.'));
        JSONArray elementsArray = new JSONArray();
        for (Dto element : elements) {
            elementsArray.put(element.toJson());
        }
        result.put("elements", elementsArray);
        return result;
    }
}
