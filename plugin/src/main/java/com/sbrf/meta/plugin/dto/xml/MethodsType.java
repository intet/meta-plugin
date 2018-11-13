
package com.sbrf.meta.plugin.dto.xml;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Контейнер информации об методах Api
 * 
 * <p>Java class for methodsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="methodsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="method" type="{http://www.sberbank.ru/meta}methodType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "methodsType", namespace = "http://www.sberbank.ru/meta", propOrder = {
    "method"
})
public class MethodsType {

    @XmlElement(namespace = "http://www.sberbank.ru/meta")
    protected List<MethodType> method;

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

}
