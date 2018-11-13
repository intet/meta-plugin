
package com.sbrf.meta.plugin.dto.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for fieldType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="fieldType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="class" type="{http://www.sberbank.ru/meta}classType"/>
 *         &lt;element name="static" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="final" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="access">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="public"/>
 *               &lt;enumeration value="protected"/>
 *               &lt;enumeration value="default"/>
 *               &lt;enumeration value="private"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fieldType", namespace = "http://www.sberbank.ru/meta", propOrder = {
    "name",
    "clazz",
    "_static",
    "_final",
    "access"
})
public class FieldType {

    @XmlElement(namespace = "http://www.sberbank.ru/meta", required = true)
    protected String name;
    @XmlElement(name = "class", namespace = "http://www.sberbank.ru/meta", required = true)
    protected ClassType clazz;
    @XmlElement(name = "static", namespace = "http://www.sberbank.ru/meta", defaultValue = "false")
    protected boolean _static;
    @XmlElement(name = "final", namespace = "http://www.sberbank.ru/meta", defaultValue = "false")
    protected boolean _final;
    @XmlElement(namespace = "http://www.sberbank.ru/meta", required = true)
    protected String access;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the clazz property.
     * 
     * @return
     *     possible object is
     *     {@link ClassType }
     *     
     */
    public ClassType getClazz() {
        return clazz;
    }

    /**
     * Sets the value of the clazz property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClassType }
     *     
     */
    public void setClazz(ClassType value) {
        this.clazz = value;
    }

    /**
     * Gets the value of the static property.
     * 
     */
    public boolean isStatic() {
        return _static;
    }

    /**
     * Sets the value of the static property.
     * 
     */
    public void setStatic(boolean value) {
        this._static = value;
    }

    /**
     * Gets the value of the final property.
     * 
     */
    public boolean isFinal() {
        return _final;
    }

    /**
     * Sets the value of the final property.
     * 
     */
    public void setFinal(boolean value) {
        this._final = value;
    }

    /**
     * Gets the value of the access property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccess() {
        return access;
    }

    /**
     * Sets the value of the access property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccess(String value) {
        this.access = value;
    }

}
