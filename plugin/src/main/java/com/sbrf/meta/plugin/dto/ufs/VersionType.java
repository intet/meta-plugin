
package com.sbrf.meta.plugin.dto.ufs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Version_Type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Version_Type">
 *   &lt;restriction base="{}C">
 *     &lt;enumeration value="Snapshot"/>
 *     &lt;enumeration value="Release"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Version_Type")
@XmlEnum
public enum VersionType {

    @XmlEnumValue("Snapshot")
    SNAPSHOT("Snapshot"),
    @XmlEnumValue("Release")
    RELEASE("Release");
    private final String value;

    VersionType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static VersionType fromValue(String v) {
        for (VersionType c: VersionType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
