
package com.sbrf.meta.plugin.dto.ufs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CallTemplate_Type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CallTemplate_Type">
 *   &lt;restriction base="{}C">
 *     &lt;enumeration value="CallReply"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CallTemplate_Type")
@XmlEnum
public enum CallTemplateType {

    @XmlEnumValue("CallReply")
    CALL_REPLY("CallReply");
    private final String value;

    CallTemplateType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CallTemplateType fromValue(String v) {
        for (CallTemplateType c: CallTemplateType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
