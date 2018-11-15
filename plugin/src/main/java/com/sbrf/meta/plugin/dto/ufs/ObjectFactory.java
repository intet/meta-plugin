
package com.sbrf.meta.plugin.dto.ufs;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.sbrf.meta.plugin.dto.ufs package. 
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

    private final static QName _UfsCandidateApiImportRq_QNAME = new QName("", "UfsCandidateApiImportRq");
    private final static QName _UfsCandidateApiImportRs_QNAME = new QName("", "UfsCandidateApiImportRs");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.sbrf.meta.plugin.dto.ufs
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UfsCandidateApiImportRqType }
     * 
     */
    public UfsCandidateApiImportRqType createUfsCandidateApiImportRqType() {
        return new UfsCandidateApiImportRqType();
    }

    /**
     * Create an instance of {@link UfsCandidateApiImportRsType }
     * 
     */
    public UfsCandidateApiImportRsType createUfsCandidateApiImportRsType() {
        return new UfsCandidateApiImportRsType();
    }

    /**
     * Create an instance of {@link StepType }
     * 
     */
    public StepType createStepType() {
        return new StepType();
    }

    /**
     * Create an instance of {@link BFSVersionType }
     * 
     */
    public BFSVersionType createBFSVersionType() {
        return new BFSVersionType();
    }

    /**
     * Create an instance of {@link BFSType }
     * 
     */
    public BFSType createBFSType() {
        return new BFSType();
    }

    /**
     * Create an instance of {@link ModuleType }
     * 
     */
    public ModuleType createModuleType() {
        return new ModuleType();
    }

    /**
     * Create an instance of {@link MavenArtifactType }
     * 
     */
    public MavenArtifactType createMavenArtifactType() {
        return new MavenArtifactType();
    }

    /**
     * Create an instance of {@link ReturnTypeType }
     * 
     */
    public ReturnTypeType createReturnTypeType() {
        return new ReturnTypeType();
    }

    /**
     * Create an instance of {@link ExceptionType }
     * 
     */
    public ExceptionType createExceptionType() {
        return new ExceptionType();
    }

    /**
     * Create an instance of {@link ModuleVersionType }
     * 
     */
    public ModuleVersionType createModuleVersionType() {
        return new ModuleVersionType();
    }

    /**
     * Create an instance of {@link RsStatusType }
     * 
     */
    public RsStatusType createRsStatusType() {
        return new RsStatusType();
    }

    /**
     * Create an instance of {@link ParamType }
     * 
     */
    public ParamType createParamType() {
        return new ParamType();
    }

    /**
     * Create an instance of {@link APIType }
     * 
     */
    public APIType createAPIType() {
        return new APIType();
    }

    /**
     * Create an instance of {@link LoadStatusType }
     * 
     */
    public LoadStatusType createLoadStatusType() {
        return new LoadStatusType();
    }

    /**
     * Create an instance of {@link APIIMType }
     * 
     */
    public APIIMType createAPIIMType() {
        return new APIIMType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UfsCandidateApiImportRqType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "UfsCandidateApiImportRq")
    public JAXBElement<UfsCandidateApiImportRqType> createUfsCandidateApiImportRq(UfsCandidateApiImportRqType value) {
        return new JAXBElement<UfsCandidateApiImportRqType>(_UfsCandidateApiImportRq_QNAME, UfsCandidateApiImportRqType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UfsCandidateApiImportRsType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "UfsCandidateApiImportRs")
    public JAXBElement<UfsCandidateApiImportRsType> createUfsCandidateApiImportRs(UfsCandidateApiImportRsType value) {
        return new JAXBElement<UfsCandidateApiImportRsType>(_UfsCandidateApiImportRs_QNAME, UfsCandidateApiImportRsType.class, null, value);
    }

}
