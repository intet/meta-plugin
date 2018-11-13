
package com.sbrf.meta.plugin.dto.xml;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Информация об Api
 * 
 * <p>Java class for apiDeclarationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="apiDeclarationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="class" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="method" type="{http://www.sberbank.ru/meta}methodType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="gav" type="{http://www.sberbank.ru/meta}gavType"/>
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
@XmlType(name = "apiDeclarationType", namespace = "http://www.sberbank.ru/meta", propOrder = {
    "clazz",
    "method",
    "gav",
    "comment"
})
public class ApiDeclarationType {

    @XmlElement(name = "class", namespace = "http://www.sberbank.ru/meta", required = true)
    protected String clazz;
    @XmlElement(namespace = "http://www.sberbank.ru/meta")
    protected List<MethodType> method;
    @XmlElement(namespace = "http://www.sberbank.ru/meta", required = true)
    protected GavType gav;
    @XmlElement(namespace = "http://www.sberbank.ru/meta")
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
     * Gets the value of the method property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the method property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMethod().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MethodType }
     * 
     * 
     */
    public List<MethodType> getMethod() {
        if (method == null) {
            method = new ArrayList<MethodType>();
        }
        return this.method;
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
