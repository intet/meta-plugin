
package com.sbrf.meta.plugin.dto.ufs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ApiType_Type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ApiType_Type">
 *   &lt;restriction base="{}C">
 *     &lt;enumeration value="WORKFLOW"/>
 *     &lt;enumeration value="REST"/>
 *     &lt;enumeration value="JAVA"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ApiType_Type")
@XmlEnum
public enum ApiTypeType {

    WORKFLOW,
    REST,
    JAVA;

    public String value() {
        return name();
    }

    public static ApiTypeType fromValue(String v) {
        return valueOf(v);
    }

}
