package com.sbrf.meta.plugin.dto.api;

import com.sbrf.meta.plugin.asm.util.DtoUtils;
import com.sbrf.meta.plugin.dto.xml.DtoType;
import com.sbrf.meta.plugin.dto.xml.FieldsType;
import com.sbrf.meta.plugin.dto.xml.ModuleType;
import org.apache.bcel.classfile.Utility;
import org.json.JSONObject;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static com.sbrf.meta.plugin.asm.util.DtoUtils.getClassType;
import static com.sbrf.meta.plugin.asm.util.DtoUtils.getModule;

public class Dto {
    public final String dtoClass;
    public final boolean extend;
    public final boolean supper;
    public final GAV gav;
    public final Map<String, Field> fields = new HashMap<>();
    public String superClass;

    public Dto(String dtoClass, boolean extend, boolean supper, GAV gav) {
        this.dtoClass = dtoClass;
        this.extend = extend;
        this.supper = supper;
        this.gav = gav;
    }

    public Dto(ClassNode classNode, Map<String, ClassNode> nodes, boolean extend, boolean supper, ApiStorage storage, Map<String, GAV> metaInfo) {
        this(classNode.name, extend, supper, metaInfo.get(classNode.name));
        this.superClass = DtoUtils.getDto(classNode.superName, nodes, storage, metaInfo);
        if (classNode.fields != null) {
            for (FieldNode field : classNode.fields) {
                String fieldClass = field.signature != null ? field.signature : field.desc;
                if (fieldClass.length() < 2)
                    continue;
                fieldClass = Utility.methodSignatureReturnType("()" + fieldClass);
                String fieldDto = DtoUtils.getDto(fieldClass, nodes, storage, metaInfo);
                boolean isFinal = (field.access & Opcodes.ACC_FINAL) != 0;
                boolean isStatic = (field.access & Opcodes.ACC_STATIC) != 0;
                String access = getAccess(field.access);
                Field fieldObj = new Field(field.name, fieldDto, access, isFinal, isStatic);
                this.fields.put(field.name, fieldObj);
            }
        }
    }

    private String getAccess(int access) {
        boolean isPublic = (access & Opcodes.ACC_PUBLIC) != 0;
        boolean isPrivate = (access & Opcodes.ACC_PRIVATE) != 0;
        boolean isProtected = (access & Opcodes.ACC_PROTECTED) != 0;

        return isPublic ? "public" :
                isProtected ? "protected" :
                        isPrivate ? "private" : "default";
    }

    public JSONObject toJson() {
        JSONObject result = new JSONObject();
        result.put("class", dtoClass);
        result.put("class", dtoClass);
        if (extend)
            result.put("extend", "true");
        if (fields.size() > 0) {
            JSONObject dtoArray = new JSONObject();
            for (Map.Entry<String, Field> entry : fields.entrySet()) {
                dtoArray.put(entry.getKey(), entry.getValue().className);
            }
            result.put("fields", dtoArray);
        }
        if (this.superClass != null)
            result.put("super", this.superClass);
        return result;
    }

    public void toModule(Map<GAV, ModuleType> moduleMap, Map<String, Dto> dtoMap, Map<GAV, Set<GAV>> dependencyMap, String key) {
        DtoType result = new DtoType();
        result.setClazz(getClassType(dtoClass, superClass));
        result.getClazz().setName(key);
        FieldsType dtoArray = new FieldsType();
        for (Field field : fields.values()) {
            dtoArray.getField().add(field.toXml());
            DtoUtils.addDependencies(gav, dtoMap, dependencyMap, field.className);
        }

        result.setFields(dtoArray);
        ModuleType module;
        if (gav == null)
            module = getModule(moduleMap, new GAV("java.util", "", ""));
        else
            module = getModule(moduleMap, gav);
        module.getDto().add(result);
    }

}
