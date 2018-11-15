
package com.sbrf.meta.plugin.dto.ufs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LoadStatusId_Type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="LoadStatusId_Type">
 *   &lt;restriction base="{}C">
 *     &lt;enumeration value="SUCCESS"/>
 *     &lt;enumeration value="LOAD_WITH_ERROR"/>
 *     &lt;enumeration value="FAIL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "LoadStatusId_Type")
@XmlEnum
public enum LoadStatusIdType {

    SUCCESS,
    LOAD_WITH_ERROR,
    FAIL;

    public String value() {
        return name();
    }

    public static LoadStatusIdType fromValue(String v) {
        return valueOf(v);
    }

}
