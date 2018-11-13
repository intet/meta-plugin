package com.sbrf.meta.plugin.dto.api;

import com.sbrf.meta.plugin.asm.util.DtoUtils;
import com.sbrf.meta.plugin.dto.xml.FieldType;

public class Field {
    public final String name;
    public final String className;
    public final String access;
    public final boolean isFinal;
    public final boolean isStatic;

    public Field(String name, String className, String access, boolean isFinal, boolean isStatic) {
        this.name = name;
        this.className = className;
        this.access = access;
        this.isFinal = isFinal;
        this.isStatic = isStatic;
    }

    public FieldType toXml() {
        FieldType result = new FieldType();
        result.setName(name);
        result.setClazz(DtoUtils.getClassType(className));
        result.setAccess(access);
        result.setFinal(isFinal);
        result.setStatic(isStatic);
        return result;
    }
}
