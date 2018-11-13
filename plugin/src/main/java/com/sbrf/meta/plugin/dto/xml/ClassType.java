
package com.sbrf.meta.plugin.dto.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for classType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="classType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="isArray" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="super" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="types" type="{http://www.sberbank.ru/meta}typesType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "classType", namespace = "http://www.sberbank.ru/meta", propOrder = {
    "type",
    "isArray",
    "_super",
    "types"
})
public class ClassType {

    @XmlElement(namespace = "http://www.sberbank.ru/meta", required = true)
    protected String type;
    @XmlElement(namespace = "http://www.sberbank.ru/meta", defaultValue = "false")
    protected Boolean isArray;
    @XmlElement(name = "super", namespace = "http://www.sberbank.ru/meta")
    protected String _super;
    @XmlElement(namespace = "http://www.sberbank.ru/meta")
    protected TypesType types;

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the isArray property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsArray() {
        return isArray;
    }

    /**
     * Sets the value of the isArray property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsArray(Boolean value) {
        this.isArray = value;
    }

    /**
     * Gets the value of the super property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSuper() {
        return _super;
    }

    /**
     * Sets the value of the super property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSuper(String value) {
        this._super = value;
    }

    /**
     * Gets the value of the types property.
     * 
     * @return
     *     possible object is
     *     {@link TypesType }
     *     
     */
    public TypesType getTypes() {
        return types;
    }

    /**
     * Sets the value of the types property.
     * 
     * @param value
     *     allowed object is
     *     {@link TypesType }
     *     
     */
    public void setTypes(TypesType value) {
        this.types = value;
    }

}
