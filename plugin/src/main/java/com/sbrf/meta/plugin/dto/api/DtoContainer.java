package com.sbrf.meta.plugin.dto.api;

import com.sbrf.meta.plugin.asm.util.DtoUtils;
import com.sbrf.meta.plugin.dto.xml.DtoType;
import com.sbrf.meta.plugin.dto.xml.FieldsType;
import com.sbrf.meta.plugin.dto.xml.ModuleType;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import static com.sbrf.meta.plugin.asm.util.DtoUtils.getClassType;
import static com.sbrf.meta.plugin.asm.util.DtoUtils.getModule;

public class DtoContainer extends Dto {
    public final Collection<String> elements;

    public DtoContainer(String containerClass, Collection<String> elements, boolean extend, boolean supper, GAV gav) {
        super(containerClass, extend, supper, gav);
        this.elements = elements;
    }


    public void toModule(Map<GAV, ModuleType> moduleMap, Map<String, Dto> dtoMap, Map<GAV, Set<GAV>> dependencyMap, String name) {
        DtoType result = new DtoType();
        result.setClazz(getClassType(dtoClass, elements));
        result.setParent(superClass);
        result.getClazz().setName(name);
        FieldsType dtoArray = new FieldsType();
        for (Field field : fields.values()) {
            dtoArray.getField().add(field.toXml());
        }
        for (String element : elements) {
            DtoUtils.addDependencies(gav, dtoMap, dependencyMap, element);
        }

        result.setFields(dtoArray);
        ModuleType module;
        if (gav == null)
            module = getModule(moduleMap, new GAV("", "", ""));
        else
            module = getModule(moduleMap, gav);
        module.getDto().add(result);
    }
}
