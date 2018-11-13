
package com.sbrf.meta.plugin.dto.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for rootType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="rootType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="apis" type="{http://www.sberbank.ru/meta}apisType"/>
 *         &lt;element name="dtos" type="{http://www.sberbank.ru/meta}dtosType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rootType", namespace = "http://www.sberbank.ru/meta", propOrder = {
    "apis",
    "dtos"
})
public class RootType {

    @XmlElement(namespace = "http://www.sberbank.ru/meta", required = true)
    protected ApisType apis;
    @XmlElement(namespace = "http://www.sberbank.ru/meta", required = true)
    protected DtosType dtos;

    /**
     * Gets the value of the apis property.
     * 
     * @return
     *     possible object is
     *     {@link ApisType }
     *     
     */
    public ApisType getApis() {
        return apis;
    }

    /**
     * Sets the value of the apis property.
     * 
     * @param value
     *     allowed object is
     *     {@link ApisType }
     *     
     */
    public void setApis(ApisType value) {
        this.apis = value;
    }

    /**
     * Gets the value of the dtos property.
     * 
     * @return
     *     possible object is
     *     {@link DtosType }
     *     
     */
    public DtosType getDtos() {
        return dtos;
    }

    /**
     * Sets the value of the dtos property.
     * 
     * @param value
     *     allowed object is
     *     {@link DtosType }
     *     
     */
    public void setDtos(DtosType value) {
        this.dtos = value;
    }

}
