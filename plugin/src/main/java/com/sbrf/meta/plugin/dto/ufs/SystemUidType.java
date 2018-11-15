
package com.sbrf.meta.plugin.dto.ufs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SystemUid_Type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SystemUid_Type">
 *   &lt;restriction base="{}C">
 *     &lt;enumeration value="PPRB"/>
 *     &lt;enumeration value="EFS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SystemUid_Type")
@XmlEnum
public enum SystemUidType {

    PPRB,
    EFS;

    public String value() {
        return name();
    }

    public static SystemUidType fromValue(String v) {
        return valueOf(v);
    }

}
