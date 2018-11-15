
package com.sbrf.meta.plugin.dto.ufs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Сущность: Сервис
 * 
 * <p>Java class for API_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="API_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{}C"/>
 *         &lt;element name="cmpUid" type="{}C"/>
 *         &lt;element name="technicalName" type="{}C" minOccurs="0"/>
 *         &lt;element name="logicalName" type="{}C"/>
 *         &lt;element name="description" type="{}C" minOccurs="0"/>
 *         &lt;element name="domain" type="{}C" minOccurs="0"/>
 *         &lt;element name="apiClassifier" type="{}C" minOccurs="0"/>
 *         &lt;element name="apiTechnology" type="{}C" minOccurs="0"/>
 *         &lt;element name="subCmpUid" type="{}C" minOccurs="0"/>
 *         &lt;element name="systemUid" type="{}SystemUid_Type"/>
 *         &lt;element name="apiType" type="{}ApiType_Type" minOccurs="0"/>
 *         &lt;element name="versions" type="{}APIIM_Type" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "API_Type", propOrder = {
    "id",
    "cmpUid",
    "technicalName",
    "logicalName",
    "description",
    "domain",
    "apiClassifier",
    "apiTechnology",
    "subCmpUid",
    "systemUid",
    "apiType",
    "versions"
})
public class APIType {

    @XmlElement(required = true)
    protected String id;
    @XmlElement(required = true)
    protected String cmpUid;
    protected String technicalName;
    @XmlElement(required = true)
    protected String logicalName;
    protected String description;
    protected String domain;
    protected String apiClassifier;
    protected String apiTechnology;
    protected String subCmpUid;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected SystemUidType systemUid;
    @XmlSchemaType(name = "string")
    protected ApiTypeType apiType;
    protected List<APIIMType> versions;

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
     * Gets the value of the cmpUid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCmpUid() {
        return cmpUid;
    }

    /**
     * Sets the value of the cmpUid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCmpUid(String value) {
        this.cmpUid = value;
    }

    /**
     * Gets the value of the technicalName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTechnicalName() {
        return technicalName;
    }

    /**
     * Sets the value of the technicalName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTechnicalName(String value) {
        this.technicalName = value;
    }

    /**
     * Gets the value of the logicalName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLogicalName() {
        return logicalName;
    }

    /**
     * Sets the value of the logicalName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLogicalName(String value) {
        this.logicalName = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the domain property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDomain() {
        return domain;
    }

    /**
     * Sets the value of the domain property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDomain(String value) {
        this.domain = value;
    }

    /**
     * Gets the value of the apiClassifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApiClassifier() {
        return apiClassifier;
    }

    /**
     * Sets the value of the apiClassifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApiClassifier(String value) {
        this.apiClassifier = value;
    }

    /**
     * Gets the value of the apiTechnology property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApiTechnology() {
        return apiTechnology;
    }

    /**
     * Sets the value of the apiTechnology property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApiTechnology(String value) {
        this.apiTechnology = value;
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
     * Gets the value of the systemUid property.
     * 
     * @return
     *     possible object is
     *     {@link SystemUidType }
     *     
     */
    public SystemUidType getSystemUid() {
        return systemUid;
    }

    /**
     * Sets the value of the systemUid property.
     * 
     * @param value
     *     allowed object is
     *     {@link SystemUidType }
     *     
     */
    public void setSystemUid(SystemUidType value) {
        this.systemUid = value;
    }

    /**
     * Gets the value of the apiType property.
     * 
     * @return
     *     possible object is
     *     {@link ApiTypeType }
     *     
     */
    public ApiTypeType getApiType() {
        return apiType;
    }

    /**
     * Sets the value of the apiType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ApiTypeType }
     *     
     */
    public void setApiType(ApiTypeType value) {
        this.apiType = value;
    }

    /**
     * Gets the value of the versions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the versions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVersions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link APIIMType }
     * 
     * 
     */
    public List<APIIMType> getVersions() {
        if (versions == null) {
            versions = new ArrayList<APIIMType>();
        }
        return this.versions;
    }

}
