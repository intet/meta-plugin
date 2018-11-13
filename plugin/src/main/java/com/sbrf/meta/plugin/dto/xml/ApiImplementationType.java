
package com.sbrf.meta.plugin.dto.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Информация об имплементации Api
 * 
 * <p>Java class for apiImplementationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="apiImplementationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="apiClass" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="class" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="gav" type="{http://www.sberbank.ru/meta}gavType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "apiImplementationType", namespace = "http://www.sberbank.ru/meta", propOrder = {
    "apiClass",
    "clazz",
    "gav"
})
public class ApiImplementationType {

    @XmlElement(namespace = "http://www.sberbank.ru/meta", required = true)
    protected String apiClass;
    @XmlElement(name = "class", namespace = "http://www.sberbank.ru/meta", required = true)
    protected String clazz;
    @XmlElement(namespace = "http://www.sberbank.ru/meta", required = true)
    protected GavType gav;

    /**
     * Gets the value of the apiClass property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApiClass() {
        return apiClass;
    }

    /**
     * Sets the value of the apiClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApiClass(String value) {
        this.apiClass = value;
    }

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

}
