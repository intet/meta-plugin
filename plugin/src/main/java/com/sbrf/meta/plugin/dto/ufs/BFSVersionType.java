
package com.sbrf.meta.plugin.dto.ufs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Версия БФС
 * 
 * <p>Java class for BFSVersion_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BFSVersion_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{}C"/>
 *         &lt;element name="bfsId" type="{}C"/>
 *         &lt;element name="versionCode" type="{}Version"/>
 *         &lt;element name="release" type="{}Release_Type"/>
 *         &lt;element name="versionType" type="{}Version_Type"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BFSVersion_Type", propOrder = {
    "id",
    "bfsId",
    "versionCode",
    "release",
    "versionType"
})
public class BFSVersionType {

    @XmlElement(required = true)
    protected String id;
    @XmlElement(required = true)
    protected String bfsId;
    @XmlElement(required = true)
    protected String versionCode;
    @XmlElement(required = true)
    protected String release;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected VersionType versionType;

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
     * Gets the value of the bfsId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBfsId() {
        return bfsId;
    }

    /**
     * Sets the value of the bfsId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBfsId(String value) {
        this.bfsId = value;
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

}
