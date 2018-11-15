
package com.sbrf.meta.plugin.dto.ufs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Ñóùíîñòü: ÁÔÑ (CmpEntity)
 * 
 * <p>Java class for BFS_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BFS_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{}C"/>
 *         &lt;element name="apiId" type="{}C" minOccurs="0"/>
 *         &lt;element name="logicalName" type="{}C"/>
 *         &lt;element name="technicalName" type="{}C" minOccurs="0"/>
 *         &lt;element name="description" type="{}C" minOccurs="0"/>
 *         &lt;element name="status" type="{}Status_Type" minOccurs="0"/>
 *         &lt;element name="confluenceLink" type="{}URL_Type" minOccurs="0"/>
 *         &lt;element name="versions" type="{}BFSVersion_Type" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="packages" type="{}Package_Type" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BFS_Type", propOrder = {
    "id",
    "apiId",
    "logicalName",
    "technicalName",
    "description",
    "status",
    "confluenceLink",
    "versions",
    "packages"
})
public class BFSType {

    @XmlElement(required = true)
    protected String id;
    protected String apiId;
    @XmlElement(required = true)
    protected String logicalName;
    protected String technicalName;
    protected String description;
    @XmlSchemaType(name = "string")
    protected StatusType status;
    protected String confluenceLink;
    protected List<BFSVersionType> versions;
    protected List<String> packages;

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
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link StatusType }
     *     
     */
    public StatusType getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatusType }
     *     
     */
    public void setStatus(StatusType value) {
        this.status = value;
    }

    /**
     * Gets the value of the confluenceLink property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConfluenceLink() {
        return confluenceLink;
    }

    /**
     * Sets the value of the confluenceLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConfluenceLink(String value) {
        this.confluenceLink = value;
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
     * {@link BFSVersionType }
     * 
     * 
     */
    public List<BFSVersionType> getVersions() {
        if (versions == null) {
            versions = new ArrayList<BFSVersionType>();
        }
        return this.versions;
    }

    /**
     * Gets the value of the packages property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the packages property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPackages().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getPackages() {
        if (packages == null) {
            packages = new ArrayList<String>();
        }
        return this.packages;
    }

}
