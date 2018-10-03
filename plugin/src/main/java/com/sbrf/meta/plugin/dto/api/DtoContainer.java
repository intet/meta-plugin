package com.sbrf.meta.plugin.dto.api;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Collection;

public class DtoContainer extends Dto {
    public final Collection<String> elements;

    public DtoContainer(String containerClass, Collection<String> elements, boolean extend, boolean supper) {
        super(containerClass, extend, supper);
        this.elements = elements;
    }

    public JSONObject toJson() {
        JSONObject result = new JSONObject();
        JSONArray elementsArray = new JSONArray();
        for (String element : elements) {
            elementsArray.put(element);
        }
        result.put("class", dtoClass);
        result.put("elements", elementsArray);
        return result;
    }
}
