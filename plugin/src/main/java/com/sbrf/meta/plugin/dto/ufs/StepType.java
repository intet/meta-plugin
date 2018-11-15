
package com.sbrf.meta.plugin.dto.ufs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Сущность: FlowStep (StepEntity)
 * 
 * <p>Java class for Step_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Step_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{}C"/>
 *         &lt;element name="apiVersionId" type="{}C" minOccurs="0"/>
 *         &lt;element name="logicalName" type="{}C"/>
 *         &lt;element name="technicalName" type="{}C" minOccurs="0"/>
 *         &lt;element name="testable" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Step_Type", propOrder = {
    "id",
    "apiVersionId",
    "logicalName",
    "technicalName",
    "testable"
})
public class StepType {

    @XmlElement(required = true)
    protected String id;
    protected String apiVersionId;
    @XmlElement(required = true)
    protected String logicalName;
    protected String technicalName;
    protected boolean testable;

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
     * Gets the value of the apiVersionId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApiVersionId() {
        return apiVersionId;
    }

    /**
     * Sets the value of the apiVersionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApiVersionId(String value) {
        this.apiVersionId = value;
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
     * Gets the value of the testable property.
     * 
     */
    public boolean isTestable() {
        return testable;
    }

    /**
     * Sets the value of the testable property.
     * 
     */
    public void setTestable(boolean value) {
        this.testable = value;
    }

}
