
package com.sbrf.meta.plugin.dto.xml;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Контейнер информации об Api
 * 
 * <p>Java class for apisType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="apisType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="api" type="{http://www.sberbank.ru/meta}apiType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "apisType", namespace = "http://www.sberbank.ru/meta", propOrder = {
    "api"
})
public class ApisType {

    @XmlElement(namespace = "http://www.sberbank.ru/meta")
    protected List<ApiType> api;

    /**
     * Gets the value of the api property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the api property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getApi().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ApiType }
     * 
     * 
     */
    public List<ApiType> getApi() {
        if (api == null) {
            api = new ArrayList<ApiType>();
        }
        return this.api;
    }

}
