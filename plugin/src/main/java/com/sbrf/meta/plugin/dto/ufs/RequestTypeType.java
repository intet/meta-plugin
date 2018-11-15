
package com.sbrf.meta.plugin.dto.ufs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RequestType_Type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RequestType_Type">
 *   &lt;restriction base="{}C">
 *     &lt;enumeration value="Sync"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RequestType_Type")
@XmlEnum
public enum RequestTypeType {

    @XmlEnumValue("Sync")
    SYNC("Sync");
    private final String value;

    RequestTypeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RequestTypeType fromValue(String v) {
        for (RequestTypeType c: RequestTypeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
