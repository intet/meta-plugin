
package com.sbrf.meta.plugin.dto.ufs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Статус обработки
 * 
 * <p>Java class for RsStatus_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RsStatus_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="statusId" type="{}LoadStatusId_Type"/>
 *         &lt;element name="statusDesc" type="{}C6000_Type"/>
 *         &lt;element name="loadStatus" type="{}LoadStatus_Type" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RsStatus_Type", propOrder = {
    "statusId",
    "statusDesc",
    "loadStatus"
})
public class RsStatusType {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected LoadStatusIdType statusId;
    @XmlElement(required = true)
    protected String statusDesc;
    protected List<LoadStatusType> loadStatus;

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
     * Gets the value of the loadStatus property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the loadStatus property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLoadStatus().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LoadStatusType }
     * 
     * 
     */
    public List<LoadStatusType> getLoadStatus() {
        if (loadStatus == null) {
            loadStatus = new ArrayList<LoadStatusType>();
        }
        return this.loadStatus;
    }

}
