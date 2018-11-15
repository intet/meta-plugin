
package com.sbrf.meta.plugin.dto.ufs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Статус обработки сервиса
 * 
 * <p>Java class for LoadStatus_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LoadStatus_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="entityType" type="{}EntityType_Type"/>
 *         &lt;element name="statusId" type="{}LoadStatusId_Type"/>
 *         &lt;element name="statusDesc" type="{}C6000_Type"/>
 *         &lt;element name="id" type="{}C"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoadStatus_Type", propOrder = {
    "entityType",
    "statusId",
    "statusDesc",
    "id"
})
public class LoadStatusType {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected EntityTypeType entityType;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected LoadStatusIdType statusId;
    @XmlElement(required = true)
    protected String statusDesc;
    @XmlElement(required = true)
    protected String id;

    /**
     * Gets the value of the entityType property.
     * 
     * @return
     *     possible object is
     *     {@link EntityTypeType }
     *     
     */
    public EntityTypeType getEntityType() {
        return entityType;
    }

    /**
     * Sets the value of the entityType property.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityTypeType }
     *     
     */
    public void setEntityType(EntityTypeType value) {
        this.entityType = value;
    }

    /**
     * Gets the value of the statusId property.
     * 
     * @return
     *     possible object is
     *     {@link LoadStatusIdType }
     *     
     */
    public LoadStatusIdType getStatusId() {
        return statusId;
    }

    /**
     * Sets the value of the statusId property.
     * 
     * @param value
     *     allowed object is
     *     {@link LoadStatusIdType }
     *     
     */
    public void setStatusId(LoadStatusIdType value) {
        this.statusId = value;
    }

    /**
     * Gets the value of the statusDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusDesc() {
        return statusDesc;
    }

    /**
     * Sets the value of the statusDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusDesc(String value) {
        this.statusDesc = value;
    }

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

}
