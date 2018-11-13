
package com.sbrf.meta.plugin.dto.xml;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for moduleType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="moduleType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="gav" type="{http://www.sberbank.ru/meta}gavType"/>
 *         &lt;element name="apiDeclaration" type="{http://www.sberbank.ru/meta}apiDeclarationType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="apiImplementation" type="{http://www.sberbank.ru/meta}apiImplementationType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="apiInvocationType" type="{http://www.sberbank.ru/meta}apiInvocationType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="dto" type="{http://www.sberbank.ru/meta}dtoType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="dependencies" type="{http://www.sberbank.ru/meta}gavType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "moduleType", namespace = "http://www.sberbank.ru/meta", propOrder = {
    "gav",
    "apiDeclaration",
    "apiImplementation",
    "apiInvocationType",
    "dto",
    "dependencies"
})
public class ModuleType {

    @XmlElement(namespace = "http://www.sberbank.ru/meta", required = true)
    protected GavType gav;
    @XmlElement(namespace = "http://www.sberbank.ru/meta")
    protected List<ApiDeclarationType> apiDeclaration;
    @XmlElement(namespace = "http://www.sberbank.ru/meta")
    protected List<ApiImplementationType> apiImplementation;
    @XmlElement(namespace = "http://www.sberbank.ru/meta")
    protected List<ApiInvocationType> apiInvocationType;
    @XmlElement(namespace = "http://www.sberbank.ru/meta")
    protected List<DtoType> dto;
    @XmlElement(namespace = "http://www.sberbank.ru/meta")
    protected List<GavType> dependencies;

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
     * Gets the value of the apiDeclaration property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the apiDeclaration property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getApiDeclaration().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ApiDeclarationType }
     * 
     * 
     */
    public List<ApiDeclarationType> getApiDeclaration() {
        if (apiDeclaration == null) {
            apiDeclaration = new ArrayList<ApiDeclarationType>();
        }
        return this.apiDeclaration;
    }

    /**
     * Gets the value of the apiImplementation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the apiImplementation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getApiImplementation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ApiImplementationType }
     * 
     * 
     */
    public List<ApiImplementationType> getApiImplementation() {
        if (apiImplementation == null) {
            apiImplementation = new ArrayList<ApiImplementationType>();
        }
        return this.apiImplementation;
    }

    /**
     * Gets the value of the apiInvocationType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the apiInvocationType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getApiInvocationType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ApiInvocationType }
     * 
     * 
     */
    public List<ApiInvocationType> getApiInvocationType() {
        if (apiInvocationType == null) {
            apiInvocationType = new ArrayList<ApiInvocationType>();
        }
        return this.apiInvocationType;
    }

    /**
     * Gets the value of the dto property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dto property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDto().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DtoType }
     * 
     * 
     */
    public List<DtoType> getDto() {
        if (dto == null) {
            dto = new ArrayList<DtoType>();
        }
        return this.dto;
    }

    /**
     * Gets the value of the dependencies property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dependencies property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDependencies().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GavType }
     * 
     * 
     */
    public List<GavType> getDependencies() {
        if (dependencies == null) {
            dependencies = new ArrayList<GavType>();
        }
        return this.dependencies;
    }

}
