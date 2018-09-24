package com.sbrf.meta.plugin.dto.api;

import org.json.JSONObject;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldNode;

import java.util.HashMap;
import java.util.Map;

public class Dto {
    public String dtoClass;
    public Map<String, Dto> fields = new HashMap<>();

    public Dto(String dtoClass) {
        this.dtoClass = dtoClass;
    }

    public Dto(ClassNode classNode, Map<String, ClassNode> nodes) {
        this.dtoClass = classNode.name;
        if (classNode.fields != null) {
            for (FieldNode field : classNode.fields) {
                String fieldClass = field.desc.substring(1, field.desc.length() - 1);
                Dto fieldDto = nodes.get(fieldClass) != null ? new Dto(nodes.get(fieldClass), nodes) : new Dto(fieldClass);
                this.fields.put(field.name, fieldDto);
            }
        }
    }

    public JSONObject toJson() {
        JSONObject result = new JSONObject();
        result.put("class", dtoClass.replace('/', '.'));
        if (fields.size() > 0) {
            JSONObject dtoArray = new JSONObject();
            for (Map.Entry<String, Dto> entry : fields.entrySet()) {
                dtoArray.put(entry.getKey(), entry.getValue().toJson());
            }
            result.put("fields", dtoArray);
        }
        return result;
    }
}