package com.exadel.meetup.collections;

import static java.util.Map.entry;

import com.exadel.meetup.Annotations.After;
import com.exadel.meetup.Annotations.Before;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MapDemo {

    @Before
    class CreateUnmodifiableMapVeryOldWay {
        public Map<String, String> createUnmodifiableMap() {
            Map<String, String> map = new HashMap<>();
            map.put("I'm", "an");
            map.put("unmodifiable", "map");
            return Collections.unmodifiableMap(map);
        }
    }

    @After
    class CreateUnmodifiableMapByFabricMethod {
        public Map<String, String> createUnmodifiableMap() {
            return Map.of(
                    "I'm", "an",
                    "unmodifiable", "map"
            );
        }
    }

    @After
    class CreateUnmodifiableMapByFabricMethodWithMoreThen10Entries {
        public Map<String, String> createUnmodifiableMap() {
            return Map.ofEntries(
                    entry("I'm", "an"),
                    entry("unmodifiable", "map")
            );
        }
    }

    public static void main(String[] args) {
        new MapDemo().demo();
    }

    private void demo() {
                System.out.println(new CreateUnmodifiableMapVeryOldWay().createUnmodifiableMap());
        System.out.println(new CreateUnmodifiableMapByFabricMethod().createUnmodifiableMap());
        System.out.println(new CreateUnmodifiableMapByFabricMethodWithMoreThen10Entries().createUnmodifiableMap());
    }


}
