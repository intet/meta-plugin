
package com.sbrf.meta.plugin.dto.ufs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Сущность: Версия Модуля
 * 
 * <p>Java class for ModuleVersion_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ModuleVersion_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{}C"/>
 *         &lt;element name="moduleId" type="{}C"/>
 *         &lt;element name="versionCode" type="{}Version"/>
 *         &lt;element name="subcmpUid" type="{}C" minOccurs="0"/>
 *         &lt;element name="versionType" type="{}Version_Type"/>
 *         &lt;element name="release" type="{}Release_Type"/>
 *         &lt;element name="team" type="{}C" minOccurs="0"/>
 *         &lt;element name="project" type="{}C" minOccurs="0"/>
 *         &lt;element name="documentationLink" type="{}URL_Type" minOccurs="0"/>
 *         &lt;element name="nexusUrl" type="{}URL_Type" minOccurs="0"/>
 *         &lt;element name="mavenArtifact" type="{}MavenArtifact_Type" minOccurs="0"/>
 *         &lt;element name="cmpUid" type="{}C" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ModuleVersion_Type", propOrder = {
    "id",
    "moduleId",
    "versionCode",
    "subcmpUid",
    "versionType",
    "release",
    "team",
    "project",
    "documentationLink",
    "nexusUrl",
    "mavenArtifact",
    "cmpUid"
})
public class ModuleVersionType {

    @XmlElement(required = true)
    protected String id;
    @XmlElement(required = true)
    protected String moduleId;
    @XmlElement(required = true)
    protected String versionCode;
    protected String subcmpUid;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected VersionType versionType;
    @XmlElement(required = true)
    protected String release;
    protected String team;
    protected String project;
    protected String documentationLink;
    protected String nexusUrl;
    protected MavenArtifactType mavenArtifact;
    protected String cmpUid;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the moduleId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModuleId() {
        return moduleId;
    }

    /**
     * Sets the value of the moduleId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModuleId(String value) {
        this.moduleId = value;
    }

    /**
     * Gets the value of the versionCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersionCode() {
        return versionCode;
    }

    /**
     * Sets the value of the versionCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersionCode(String value) {
        this.versionCode = value;
    }

    /**
     * Gets the value of the subcmpUid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubcmpUid() {
        return subcmpUid;
    }

    /**
     * Sets the value of the subcmpUid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubcmpUid(String value) {
        this.subcmpUid = value;
    }

    /**
     * Gets the value of the versionType property.
     * 
     * @return
     *     possible object is
     *     {@link VersionType }
     *     
     */
    public VersionType getVersionType() {
        return versionType;
    }

    /**
     * Sets the value of the versionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link VersionType }
     *     
     */
    public void setVersionType(VersionType value) {
        this.versionType = value;
    }

    /**
     * Gets the value of the release property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRelease() {
        return release;
    }

    /**
     * Sets the value of the release property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRelease(String value) {
        this.release = value;
    }

    /**
     * Gets the value of the team property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTeam() {
        return team;
    }

    /**
     * Sets the value of the team property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTeam(String value) {
        this.team = value;
    }

    /**
     * Gets the value of the project property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProject() {
        return project;
    }

    /**
     * Sets the value of the project property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProject(String value) {
        this.project = value;
    }

    /**
     * Gets the value of the documentationLink property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentationLink() {
        return documentationLink;
    }

    /**
     * Sets the value of the documentationLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentationLink(String value) {
        this.documentationLink = value;
    }

    /**
     * Gets the value of the nexusUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNexusUrl() {
        return nexusUrl;
    }

    /**
     * Sets the value of the nexusUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNexusUrl(String value) {
        this.nexusUrl = value;
    }

    /**
     * Gets the value of the mavenArtifact property.
     * 
     * @return
     *     possible object is
     *     {@link MavenArtifactType }
     *     
     */
    public MavenArtifactType getMavenArtifact() {
        return mavenArtifact;
    }

    /**
     * Sets the value of the mavenArtifact property.
     * 
     * @param value
     *     allowed object is
     *     {@link MavenArtifactType }
     *     
     */
    public void setMavenArtifact(MavenArtifactType value) {
        this.mavenArtifact = value;
    }

    /**
     * Gets the value of the cmpUid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCmpUid() {
        return cmpUid;
    }

    /**
     * Sets the value of the cmpUid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCmpUid(String value) {
        this.cmpUid = value;
    }

}
