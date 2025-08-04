package com.tharindu.oodp2.Flyweight.GUI;

import java.util.HashMap;
import java.util.Map;

// ----- Flyweight Factory -----
public class EntityFactory {
    private static final Map<String, EntityType> types = new HashMap<>();

    public static EntityType getEntityType(String name, String emoji) {
        return types.computeIfAbsent(name, k -> new EntityType(name, emoji));
    }
}
