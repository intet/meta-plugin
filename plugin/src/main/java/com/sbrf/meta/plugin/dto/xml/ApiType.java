
package com.sbrf.meta.plugin.dto.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Информация об Api
 * 
 * <p>Java class for apiType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="apiType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="class" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="methods" type="{http://www.sberbank.ru/meta}methodsType"/>
 *         &lt;element name="implementations" type="{http://www.sberbank.ru/meta}implementationsType"/>
 *         &lt;element name="gav" type="{http://www.sberbank.ru/meta}gavType"/>
 *         &lt;element name="comment" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "apiType", namespace = "http://www.sberbank.ru/meta", propOrder = {
    "clazz",
    "methods",
    "implementations",
    "gav",
    "comment"
})
public class ApiType {

    @XmlElement(name = "class", namespace = "http://www.sberbank.ru/meta", required = true)
    protected String clazz;
    @XmlElement(namespace = "http://www.sberbank.ru/meta", required = true)
    protected MethodsType methods;
    @XmlElement(namespace = "http://www.sberbank.ru/meta", required = true)
    protected ImplementationsType implementations;
    @XmlElement(namespace = "http://www.sberbank.ru/meta", required = true)
    protected GavType gav;
    @XmlElement(namespace = "http://www.sberbank.ru/meta", required = true)
    protected String comment;

    /**
     * Gets the value of the clazz property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClazz() {
        return clazz;
    }

    /**
     * Sets the value of the clazz property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClazz(String value) {
        this.clazz = value;
    }

    /**
     * Gets the value of the methods property.
     * 
     * @return
     *     possible object is
     *     {@link MethodsType }
     *     
     */
    public MethodsType getMethods() {
        return methods;
    }

    /**
     * Sets the value of the methods property.
     * 
     * @param value
     *     allowed object is
     *     {@link MethodsType }
     *     
     */
    public void setMethods(MethodsType value) {
        this.methods = value;
    }

    /**
     * Gets the value of the implementations property.
     * 
     * @return
     *     possible object is
     *     {@link ImplementationsType }
     *     
     */
    public ImplementationsType getImplementations() {
        return implementations;
    }

    /**
     * Sets the value of the implementations property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImplementationsType }
     *     
     */
    public void setImplementations(ImplementationsType value) {
        this.implementations = value;
    }

    /**
     * Gets the value of the gav property.
     * 
     * @return
     *     possible object is
     *     {@link GavType }
     *     
     */
    public GavType getGav() {
        return gav;
    }

    /**
     * Sets the value of the gav property.
     * 
     * @param value
     *     allowed object is
     *     {@link GavType }
     *     
     */
    public void setGav(GavType value) {
        this.gav = value;
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
