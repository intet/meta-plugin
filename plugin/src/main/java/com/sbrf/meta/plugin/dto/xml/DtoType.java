
package com.sbrf.meta.plugin.dto.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dtoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dtoType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="class" type="{http://www.sberbank.ru/meta}classType"/>
 *         &lt;element name="fields" type="{http://www.sberbank.ru/meta}fieldsType"/>
 *         &lt;element name="parent" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dtoType", namespace = "http://www.sberbank.ru/meta", propOrder = {
    "clazz",
    "fields",
    "parent"
})
public class DtoType {

    @XmlElement(name = "class", namespace = "http://www.sberbank.ru/meta", required = true)
    protected ClassType clazz;
    @XmlElement(namespace = "http://www.sberbank.ru/meta", required = true)
    protected FieldsType fields;
    @XmlElement(namespace = "http://www.sberbank.ru/meta")
    protected String parent;

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
     * Gets the value of the fields property.
     * 
     * @return
     *     possible object is
     *     {@link FieldsType }
     *     
     */
    public FieldsType getFields() {
        return fields;
    }

    /**
     * Sets the value of the fields property.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldsType }
     *     
     */
    public void setFields(FieldsType value) {
        this.fields = value;
    }

    /**
     * Gets the value of the parent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParent() {
        return parent;
    }

    /**
     * Sets the value of the parent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParent(String value) {
        this.parent = value;
    }

}
