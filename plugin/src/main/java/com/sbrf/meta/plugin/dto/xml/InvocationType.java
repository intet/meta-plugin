
package com.sbrf.meta.plugin.dto.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Информация о вызове метода Api
 * 
 * <p>Java class for invocationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="invocationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
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
@XmlType(name = "invocationType", namespace = "http://www.sberbank.ru/meta", propOrder = {
    "clazz",
    "gav"
})
public class InvocationType {

    @XmlElement(name = "class", namespace = "http://www.sberbank.ru/meta", required = true)
    protected String clazz;
    @XmlElement(namespace = "http://www.sberbank.ru/meta", required = true)
    protected GavType gav;

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
