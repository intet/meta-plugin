package com.sbrf.meta.plugin.dto.api;

import com.sbrf.meta.plugin.asm.util.DtoUtils;
import org.json.JSONObject;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldNode;

import java.util.HashMap;
import java.util.Map;

public class Dto {
    public final String dtoClass;
    public final boolean extend;
    public final Map<String, Dto> fields = new HashMap<>();
    public Dto superClass;

    public Dto(String dtoClass, boolean extend) {
        this.dtoClass = dtoClass;
        this.extend = extend;
    }

    public Dto(ClassNode classNode, Map<String, ClassNode> nodes, boolean extend) {
        this(classNode.name, extend);
        this.superClass = DtoUtils.getDto(classNode.superName, nodes);
        if (classNode.fields != null && !classNode.superName.equals("java/lang/Enum")) {
            for (FieldNode field : classNode.fields) {
                String fieldClass = field.signature != null ? field.signature : field.desc;
                if (fieldClass.length() < 2)
                    continue;
                fieldClass = fieldClass.substring(1, fieldClass.length() - 1);
                Dto fieldDto = DtoUtils.getDto(fieldClass, nodes);
                this.fields.put(field.name, fieldDto);
            }
        }
    }

    public JSONObject toJson() {
        JSONObject result = new JSONObject();
        result.put("class", dtoClass.replace('/', '.'));
        if (extend)
            result.put("extend", "true");
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
