
package com.sbrf.meta.plugin.dto.xml;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


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

    private final static QName _Root_QNAME = new QName("http://www.sberbank.ru/meta", "root");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.sbrf.meta.plugin.dto.xml
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RootType }
     * 
     */
    public RootType createRootType() {
        return new RootType();
    }

    /**
     * Create an instance of {@link DtosType }
     * 
     */
    public DtosType createDtosType() {
        return new DtosType();
    }

    /**
     * Create an instance of {@link InvocationsType }
     * 
     */
    public InvocationsType createInvocationsType() {
        return new InvocationsType();
    }

    /**
     * Create an instance of {@link ImplementationsType }
     * 
     */
    public ImplementationsType createImplementationsType() {
        return new ImplementationsType();
    }

    /**
     * Create an instance of {@link ApisType }
     * 
     */
    public ApisType createApisType() {
        return new ApisType();
    }

    /**
     * Create an instance of {@link MethodsType }
     * 
     */
    public MethodsType createMethodsType() {
        return new MethodsType();
    }

    /**
     * Create an instance of {@link ImplementationType }
     * 
     */
    public ImplementationType createImplementationType() {
        return new ImplementationType();
    }

    /**
     * Create an instance of {@link InvocationType }
     * 
     */
    public InvocationType createInvocationType() {
        return new InvocationType();
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
     * Create an instance of {@link ApiType }
     * 
     */
    public ApiType createApiType() {
        return new ApiType();
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

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RootType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.sberbank.ru/meta", name = "root")
    public JAXBElement<RootType> createRoot(RootType value) {
        return new JAXBElement<RootType>(_Root_QNAME, RootType.class, null, value);
    }

}
