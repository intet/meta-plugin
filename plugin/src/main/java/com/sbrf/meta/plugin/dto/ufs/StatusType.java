
package com.sbrf.meta.plugin.dto.ufs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Status_Type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Status_Type">
 *   &lt;restriction base="{}C">
 *     &lt;enumeration value="INDEFINITE"/>
 *     &lt;enumeration value="RELEASED"/>
 *     &lt;enumeration value="RELEASED_WITHOUT_PLANNING"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Status_Type")
@XmlEnum
public enum StatusType {

    INDEFINITE,
    RELEASED,
    RELEASED_WITHOUT_PLANNING;

    public String value() {
        return name();
    }

    public static StatusType fromValue(String v) {
        return valueOf(v);
    }

}
