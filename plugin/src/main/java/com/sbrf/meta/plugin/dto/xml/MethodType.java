
package com.sbrf.meta.plugin.dto.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Метод Api
 * 
 * <p>Java class for methodType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="methodType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="logicalName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="technicalName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="input" type="{http://www.sberbank.ru/meta}inputType"/>
 *         &lt;element name="output" type="{http://www.sberbank.ru/meta}classType"/>
 *         &lt;element name="version" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="signature" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="throws" type="{http://www.sberbank.ru/meta}throwsType"/>
 *         &lt;element name="comment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "methodType", namespace = "http://www.sberbank.ru/meta", propOrder = {
    "logicalName",
    "technicalName",
    "input",
    "output",
    "version",
    "signature",
    "_throws",
    "comment"
})
public class MethodType {

    @XmlElement(namespace = "http://www.sberbank.ru/meta", required = true)
    protected String logicalName;
    @XmlElement(namespace = "http://www.sberbank.ru/meta", required = true)
    protected String technicalName;
    @XmlElement(namespace = "http://www.sberbank.ru/meta", required = true)
    protected InputType input;
    @XmlElement(namespace = "http://www.sberbank.ru/meta", required = true)
    protected ClassType output;
    @XmlElement(namespace = "http://www.sberbank.ru/meta", required = true)
    protected String version;
    @XmlElement(namespace = "http://www.sberbank.ru/meta", required = true)
    protected String signature;
    @XmlElement(name = "throws", namespace = "http://www.sberbank.ru/meta", required = true)
    protected ThrowsType _throws;
    @XmlElement(namespace = "http://www.sberbank.ru/meta")
    protected String comment;

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
     * Gets the value of the input property.
     * 
     * @return
     *     possible object is
     *     {@link InputType }
     *     
     */
    public InputType getInput() {
        return input;
    }

    /**
     * Sets the value of the input property.
     * 
     * @param value
     *     allowed object is
     *     {@link InputType }
     *     
     */
    public void setInput(InputType value) {
        this.input = value;
    }

    /**
     * Gets the value of the output property.
     * 
     * @return
     *     possible object is
     *     {@link ClassType }
     *     
     */
    public ClassType getOutput() {
        return output;
    }

    /**
     * Sets the value of the output property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClassType }
     *     
     */
    public void setOutput(ClassType value) {
        this.output = value;
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
     * Gets the value of the signature property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSignature() {
        return signature;
    }

    /**
     * Sets the value of the signature property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSignature(String value) {
        this.signature = value;
    }

    /**
     * Gets the value of the throws property.
     * 
     * @return
     *     possible object is
     *     {@link ThrowsType }
     *     
     */
    public ThrowsType getThrows() {
        return _throws;
    }

    /**
     * Sets the value of the throws property.
     * 
     * @param value
     *     allowed object is
     *     {@link ThrowsType }
     *     
     */
    public void setThrows(ThrowsType value) {
        this._throws = value;
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

}
