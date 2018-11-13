
package com.sbrf.meta.plugin.dto.xml;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for invocationsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="invocationsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="invocation" type="{http://www.sberbank.ru/meta}invocationType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "invocationsType", namespace = "http://www.sberbank.ru/meta", propOrder = {
    "invocation"
})
public class InvocationsType {

    @XmlElement(namespace = "http://www.sberbank.ru/meta")
    protected List<InvocationType> invocation;

    /**
     * Gets the value of the invocation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the invocation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInvocation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InvocationType }
     * 
     * 
     */
    public List<InvocationType> getInvocation() {
        if (invocation == null) {
            invocation = new ArrayList<InvocationType>();
        }
        return this.invocation;
    }

}
