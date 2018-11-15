
package com.sbrf.meta.plugin.dto.ufs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EntityType_Type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="EntityType_Type">
 *   &lt;restriction base="{}C">
 *     &lt;enumeration value="API"/>
 *     &lt;enumeration value="API_VERSION"/>
 *     &lt;enumeration value="BFS"/>
 *     &lt;enumeration value="BFS_VERSION"/>
 *     &lt;enumeration value="MODULE"/>
 *     &lt;enumeration value="MODULE_VERSION"/>
 *     &lt;enumeration value="FLOW_STEP"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "EntityType_Type")
@XmlEnum
public enum EntityTypeType {

    API,
    API_VERSION,
    BFS,
    BFS_VERSION,
    MODULE,
    MODULE_VERSION,
    FLOW_STEP;

    public String value() {
        return name();
    }

    public static EntityTypeType fromValue(String v) {
        return valueOf(v);
    }

}
