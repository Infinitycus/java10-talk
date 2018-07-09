package com.exadel.meetup.collections;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MapDemo {

    public static void main(String[] args) {
        Map<String, String> unmodifiableMap = createUnmodifiableMap();
        System.out.println(unmodifiableMap);

        Map<Integer, String> numbers = Map.ofEntries(
                Map.entry(1, "1"),
                Map.entry(2, "2")
        );
        System.out.println(numbers);
    }

    private static Map<String, String> createUnmodifiableMap() {
        Map<String, String> map = new HashMap<>();
        map.put("I'm", "an");
        map.put("unmodifiable", "list");
        return Collections.unmodifiableMap(map);
    }
}
