
package com.sbrf.meta.plugin.dto.ufs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Получение сервисов из ИС (Запрос)
 * 
 * <p>Java class for UfsCandidateApiImportRq_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UfsCandidateApiImportRq_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RqUID" type="{}RqUID_Type"/>
 *         &lt;element name="RqTm" type="{}DateTime"/>
 *         &lt;element name="SPName" type="{}SPName_Type"/>
 *         &lt;element name="SystemId" type="{}SystemId_Type"/>
 *         &lt;element name="apiList" type="{}API_Type" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="modules" type="{}Module_Type" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="bfsList" type="{}BFS_Type" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UfsCandidateApiImportRq_Type", propOrder = {
    "rqUID",
    "rqTm",
    "spName",
    "systemId",
    "apiList",
    "modules",
    "bfsList"
})
public class UfsCandidateApiImportRqType {

    @XmlElement(name = "RqUID", required = true)
    protected String rqUID;
    @XmlElement(name = "RqTm", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar rqTm;
    @XmlElement(name = "SPName", required = true)
    protected String spName;
    @XmlElement(name = "SystemId", required = true)
    protected String systemId;
    protected List<APIType> apiList;
    protected List<ModuleType> modules;
    protected List<BFSType> bfsList;

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

    /**
     * Gets the value of the spName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSPName() {
        return spName;
    }

    /**
     * Sets the value of the spName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSPName(String value) {
        this.spName = value;
    }

    /**
     * Gets the value of the systemId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSystemId() {
        return systemId;
    }

    /**
     * Sets the value of the systemId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSystemId(String value) {
        this.systemId = value;
    }

    /**
     * Gets the value of the apiList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the apiList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getApiList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link APIType }
     * 
     * 
     */
    public List<APIType> getApiList() {
        if (apiList == null) {
            apiList = new ArrayList<APIType>();
        }
        return this.apiList;
    }

    /**
     * Gets the value of the modules property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the modules property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getModules().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ModuleType }
     * 
     * 
     */
    public List<ModuleType> getModules() {
        if (modules == null) {
            modules = new ArrayList<ModuleType>();
        }
        return this.modules;
    }

    /**
     * Gets the value of the bfsList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bfsList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBfsList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BFSType }
     * 
     * 
     */
    public List<BFSType> getBfsList() {
        if (bfsList == null) {
            bfsList = new ArrayList<BFSType>();
        }
        return this.bfsList;
    }

}
