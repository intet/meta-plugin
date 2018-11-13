
package com.sbrf.meta.plugin.dto.xml;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.sbrf.meta.plugin.dto.xml package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.sbrf.meta.plugin.dto.xml
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Root }
     * 
     */
    public Root createRoot() {
        return new Root();
    }

    /**
     * Create an instance of {@link ModuleType }
     * 
     */
    public ModuleType createModuleType() {
        return new ModuleType();
    }

    /**
     * Create an instance of {@link ApiImplementationType }
     * 
     */
    public ApiImplementationType createApiImplementationType() {
        return new ApiImplementationType();
    }

    /**
     * Create an instance of {@link ApiDeclarationType }
     * 
     */
    public ApiDeclarationType createApiDeclarationType() {
        return new ApiDeclarationType();
    }

    /**
     * Create an instance of {@link ApiInvocationType }
     * 
     */
    public ApiInvocationType createApiInvocationType() {
        return new ApiInvocationType();
    }

    /**
     * Create an instance of {@link MethodType }
     * 
     */
    public MethodType createMethodType() {
        return new MethodType();
    }

    /**
     * Create an instance of {@link TypesType }
     * 
     */
    public TypesType createTypesType() {
        return new TypesType();
    }

    /**
     * Create an instance of {@link GavType }
     * 
     */
    public GavType createGavType() {
        return new GavType();
    }

    /**
     * Create an instance of {@link InputType }
     * 
     */
    public InputType createInputType() {
        return new InputType();
    }

    /**
     * Create an instance of {@link ThrowsType }
     * 
     */
    public ThrowsType createThrowsType() {
        return new ThrowsType();
    }

    /**
     * Create an instance of {@link DtoType }
     * 
     */
    public DtoType createDtoType() {
        return new DtoType();
    }

    /**
     * Create an instance of {@link FieldType }
     * 
     */
    public FieldType createFieldType() {
        return new FieldType();
    }

    /**
     * Create an instance of {@link FieldsType }
     * 
     */
    public FieldsType createFieldsType() {
        return new FieldsType();
    }

    /**
     * Create an instance of {@link ClassType }
     * 
     */
    public ClassType createClassType() {
        return new ClassType();
    }

}
