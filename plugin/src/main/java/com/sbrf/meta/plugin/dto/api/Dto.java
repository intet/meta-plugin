package com.sbrf.meta.plugin.dto.api;

import com.sbrf.meta.plugin.asm.util.DtoUtils;
import org.json.JSONObject;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldNode;

import java.util.HashMap;
import java.util.Map;

public class Dto {
    public final String dtoClass;
    public final Map<String, Dto> fields = new HashMap<>();
    public Dto superClass;

    public Dto(String dtoClass) {
        this.dtoClass = dtoClass;
    }

    public Dto(ClassNode classNode, Map<String, ClassNode> nodes) {
        this(classNode.name);
        this.superClass = DtoUtils.getDto(classNode.superName, nodes);
        if (classNode.fields != null) {
            for (FieldNode field : classNode.fields) {
                String fieldClass = field.signature != null ? field.signature : field.desc;
                fieldClass = fieldClass.substring(1, fieldClass.length() - 1);
                Dto fieldDto = DtoUtils.getDto(fieldClass, nodes);
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
        if (this.superClass != null)
            result.put("super", this.superClass.toJson());
        return result;
    }
}
