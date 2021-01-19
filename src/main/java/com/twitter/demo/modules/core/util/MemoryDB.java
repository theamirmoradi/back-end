package com.twitter.demo.modules.core.util;

import java.util.HashMap;
import java.util.Map;

public class MemoryDB {

    private static final MemoryDB ourInstance = new MemoryDB();
    private final Map<String, Object> map;

    private MemoryDB() {
        map = new HashMap<>();
    }

    public static MemoryDB getInstance() {
        return ourInstance;
    }

    public Object get(String key) {
        return map.get(key);
    }

    public Object put(String key, Object value) {
        return map.put(key, value);
    }

    public boolean exist(String key) {
        return map.get(key) != null;
    }
}
