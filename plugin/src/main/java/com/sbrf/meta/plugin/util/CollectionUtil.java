package com.sbrf.meta.plugin.util;

import java.util.Map;

public class CollectionUtil {

    public static <K, V> V get(Map<K, V> map, K key, Class clazz) {
        V value = map.get(key);
        if (value == null) {
            try {
                value = (V) clazz.newInstance();
                map.put(key, value);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return value;
    }

}
