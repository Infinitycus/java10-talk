package com.exadel.meetup.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SetDemo {

    public static void main(String[] args) {
        Set<String> unmodifiableSet = createUnmodifiableSet();
        System.out.println(unmodifiableSet);

        Set<String> setFromArray = Collections.unmodifiableSet(
                new HashSet<>(Arrays.asList("I'm", "an", "unmodifiable", "set")));
        System.out.println(setFromArray);

        Set<String> setFromStream = Collections.unmodifiableSet(Stream.of("I'm", "an", "unmodifiable", "set")
                .collect(Collectors.toSet()));
        System.out.println(setFromStream);
    }

    private static Set<String> createUnmodifiableSet() {
        Set<String> set = new HashSet<>();
        set.add("I'm");
        set.add("an");
        set.add("unmodifiable");
        set.add("set");
        return Collections.unmodifiableSet(set);
    }
}
