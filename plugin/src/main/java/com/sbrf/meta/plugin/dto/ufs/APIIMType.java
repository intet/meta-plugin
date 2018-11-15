
package com.sbrf.meta.plugin.dto.ufs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Сущность: Версия сервиса
 * 
 * <p>Java class for APIIM_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="APIIM_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{}C"/>
 *         &lt;element name="apiId" type="{}C"/>
 *         &lt;element name="versionCode" type="{}Version" minOccurs="0"/>
 *         &lt;element name="groupId" type="{}C" minOccurs="0"/>
 *         &lt;element name="artifactId" type="{}C" minOccurs="0"/>
 *         &lt;element name="version" type="{}C" minOccurs="0"/>
 *         &lt;element name="imMethodName" type="{}C" minOccurs="0"/>
 *         &lt;element name="imPackageName" type="{}C" minOccurs="0"/>
 *         &lt;element name="imInterfaceName" type="{}C" minOccurs="0"/>
 *         &lt;element name="comment" type="{}C" minOccurs="0"/>
 *         &lt;element name="documentationLink" type="{}URL_Type" minOccurs="0"/>
 *         &lt;element name="nexusUrl" type="{}URL_Type" minOccurs="0"/>
 *         &lt;element name="release" type="{}Release_Type"/>
 *         &lt;element name="mavenArtifact" type="{}MavenArtifact_Type" minOccurs="0"/>
 *         &lt;element name="returnType" type="{}ReturnType_Type" minOccurs="0"/>
 *         &lt;element name="params" type="{}Param_Type" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="exceptions" type="{}Exception_Type" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="versionType" type="{}Version_Type"/>
 *         &lt;element name="subCmpUid" type="{}C" minOccurs="0"/>
 *         &lt;element name="serviceArchitect" type="{}C" minOccurs="0"/>
 *         &lt;element name="moduleRecUid" type="{}C" minOccurs="0"/>
 *         &lt;element name="moduleImRecUid" type="{}C" minOccurs="0"/>
 *         &lt;element name="steps" type="{}Step_Type" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "APIIM_Type", propOrder = {
    "id",
    "apiId",
    "versionCode",
    "groupId",
    "artifactId",
    "version",
    "imMethodName",
    "imPackageName",
    "imInterfaceName",
    "comment",
    "documentationLink",
    "nexusUrl",
    "release",
    "mavenArtifact",
    "returnType",
    "params",
    "exceptions",
    "versionType",
    "subCmpUid",
    "serviceArchitect",
    "moduleRecUid",
    "moduleImRecUid",
    "steps"
})
public class APIIMType {

    @XmlElement(required = true)
    protected String id;
    @XmlElement(required = true)
    protected String apiId;
    protected String versionCode;
    protected String groupId;
    protected String artifactId;
    protected String version;
    protected String imMethodName;
    protected String imPackageName;
    protected String imInterfaceName;
    protected String comment;
    protected String documentationLink;
    protected String nexusUrl;
    @XmlElement(required = true)
    protected String release;
    protected MavenArtifactType mavenArtifact;
    protected ReturnTypeType returnType;
    protected List<ParamType> params;
    protected List<ExceptionType> exceptions;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected VersionType versionType;
    protected String subCmpUid;
    protected String serviceArchitect;
    protected String moduleRecUid;
    protected String moduleImRecUid;
    protected List<StepType> steps;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the apiId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApiId() {
        return apiId;
    }

    /**
     * Sets the value of the apiId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApiId(String value) {
        this.apiId = value;
    }

    /**
     * Gets the value of the versionCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersionCode() {
        return versionCode;
    }

    /**
     * Sets the value of the versionCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersionCode(String value) {
        this.versionCode = value;
    }

    /**
     * Gets the value of the groupId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGroupId() {
        return groupId;
    }

    /**
     * Sets the value of the groupId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGroupId(String value) {
        this.groupId = value;
    }

    /**
     * Gets the value of the artifactId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArtifactId() {
        return artifactId;
    }

    /**
     * Sets the value of the artifactId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArtifactId(String value) {
        this.artifactId = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

    /**
     * Gets the value of the imMethodName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImMethodName() {
        return imMethodName;
    }

    /**
     * Sets the value of the imMethodName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImMethodName(String value) {
        this.imMethodName = value;
    }

    /**
     * Gets the value of the imPackageName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImPackageName() {
        return imPackageName;
    }

    /**
     * Sets the value of the imPackageName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImPackageName(String value) {
        this.imPackageName = value;
    }

    /**
     * Gets the value of the imInterfaceName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImInterfaceName() {
        return imInterfaceName;
    }

    /**
     * Sets the value of the imInterfaceName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImInterfaceName(String value) {
        this.imInterfaceName = value;
    }

    /**
     * Gets the value of the comment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComment() {
        return comment;
    }

    /**
     * Sets the value of the comment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComment(String value) {
        this.comment = value;
    }

    /**
     * Gets the value of the documentationLink property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentationLink() {
        return documentationLink;
    }

    /**
     * Sets the value of the documentationLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentationLink(String value) {
        this.documentationLink = value;
    }

    /**
     * Gets the value of the nexusUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNexusUrl() {
        return nexusUrl;
    }

    /**
     * Sets the value of the nexusUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNexusUrl(String value) {
        this.nexusUrl = value;
    }

    /**
     * Gets the value of the release property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRelease() {
        return release;
    }

    /**
     * Sets the value of the release property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRelease(String value) {
        this.release = value;
    }

    /**
     * Gets the value of the mavenArtifact property.
     * 
     * @return
     *     possible object is
     *     {@link MavenArtifactType }
     *     
     */
    public MavenArtifactType getMavenArtifact() {
        return mavenArtifact;
    }

    /**
     * Sets the value of the mavenArtifact property.
     * 
     * @param value
     *     allowed object is
     *     {@link MavenArtifactType }
     *     
     */
    public void setMavenArtifact(MavenArtifactType value) {
        this.mavenArtifact = value;
    }

    /**
     * Gets the value of the returnType property.
     * 
     * @return
     *     possible object is
     *     {@link ReturnTypeType }
     *     
     */
    public ReturnTypeType getReturnType() {
        return returnType;
    }

    /**
     * Sets the value of the returnType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReturnTypeType }
     *     
     */
    public void setReturnType(ReturnTypeType value) {
        this.returnType = value;
    }

    /**
     * Gets the value of the params property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the params property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParams().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ParamType }
     * 
     * 
     */
    public List<ParamType> getParams() {
        if (params == null) {
            params = new ArrayList<ParamType>();
        }
        return this.params;
    }

    /**
     * Gets the value of the exceptions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the exceptions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExceptions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExceptionType }
     * 
     * 
     */
    public List<ExceptionType> getExceptions() {
        if (exceptions == null) {
            exceptions = new ArrayList<ExceptionType>();
        }
        return this.exceptions;
    }

    /**
     * Gets the value of the versionType property.
     * 
     * @return
     *     possible object is
     *     {@link VersionType }
     *     
     */
    public VersionType getVersionType() {
        return versionType;
    }

    /**
     * Sets the value of the versionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link VersionType }
     *     
     */
    public void setVersionType(VersionType value) {
        this.versionType = value;
    }

    /**
     * Gets the value of the subCmpUid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubCmpUid() {
        return subCmpUid;
    }

    /**
     * Sets the value of the subCmpUid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubCmpUid(String value) {
        this.subCmpUid = value;
    }

    /**
     * Gets the value of the serviceArchitect property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceArchitect() {
        return serviceArchitect;
    }

    /**
     * Sets the value of the serviceArchitect property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceArchitect(String value) {
        this.serviceArchitect = value;
    }

    /**
     * Gets the value of the moduleRecUid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModuleRecUid() {
        return moduleRecUid;
    }

    /**
     * Sets the value of the moduleRecUid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModuleRecUid(String value) {
        this.moduleRecUid = value;
    }

    /**
     * Gets the value of the moduleImRecUid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModuleImRecUid() {
        return moduleImRecUid;
    }

    /**
     * Sets the value of the moduleImRecUid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModuleImRecUid(String value) {
        this.moduleImRecUid = value;
    }

    /**
     * Gets the value of the steps property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the steps property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSteps().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StepType }
     * 
     * 
     */
    public List<StepType> getSteps() {
        if (steps == null) {
            steps = new ArrayList<StepType>();
        }
        return this.steps;
    }

}
