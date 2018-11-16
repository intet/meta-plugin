
package com.sbrf.meta.plugin.dto.xml;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="module" type="{http://www.sberbank.ru/meta}moduleType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="RqUID" type="{http://www.sberbank.ru/meta}UUID"/>
 *         &lt;element name="RqTm" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "module",
    "rqUID",
    "rqTm"
})
@XmlRootElement(name = "reverseRq", namespace = "http://www.sberbank.ru/meta")
public class ReverseRq {

    @XmlElement(namespace = "http://www.sberbank.ru/meta")
    protected List<ModuleType> module;
    @XmlElement(name = "RqUID", namespace = "http://www.sberbank.ru/meta", required = true)
    protected String rqUID;
    @XmlElement(name = "RqTm", namespace = "http://www.sberbank.ru/meta", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar rqTm;

    /**
     * Gets the value of the module property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the module property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getModule().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ModuleType }
     * 
     * 
     */
    public List<ModuleType> getModule() {
        if (module == null) {
            module = new ArrayList<ModuleType>();
        }
        return this.module;
    }

    /**
     * Gets the value of the rqUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRqUID() {
        return rqUID;
    }

    /**
     * Sets the value of the rqUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRqUID(String value) {
        this.rqUID = value;
    }

    /**
     * Gets the value of the rqTm property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getRqTm() {
        return rqTm;
    }

    /**
     * Sets the value of the rqTm property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setRqTm(XMLGregorianCalendar value) {
        this.rqTm = value;
    }

}
