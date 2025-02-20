package org.example;

import java.util.HashMap;
import java.util.Map;

public class Cache {
    Map<String, Integer> cache;

    void pushToCache(String key, Integer value) {
        // Open file and push to cache
        cache = new HashMap<>();
    }

    void checkCache() {
        // Open File and check value
    }
}
