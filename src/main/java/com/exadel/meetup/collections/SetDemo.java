package com.exadel.meetup.collections;

import com.exadel.meetup.Annotations.After;
import com.exadel.meetup.Annotations.Before;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SetDemo {

    @Before
    class CreateUnmodifiableSetVeryOldWay {
        public Set<String> createUnmodifiableSet() {
            Set<String> set = new HashSet<>();
            set.add("I'm");
            set.add("an");
            set.add("unmodifiable");
            set.add("set");
            return Collections.unmodifiableSet(set);
        }
    }

    @Before
    class CreateUnmodifiableSetByArraysAsList {
        public Set<String> createUnmodifiableSet() {
            return Collections.unmodifiableSet(
                    new HashSet<>(Arrays.asList("I'm", "an", "unmodifiable", "set")));
        }
    }

    @Before
    class CreateUnmodifiableSetByStream {
        public Set<String> createUnmodifiableSet() {
            return Collections.unmodifiableSet(
                    Stream.of("I'm", "an", "unmodifiable", "set")
                            .collect(Collectors.toSet()));
        }
    }

    @After
    class CreateUnmodifiableSetByFabricMethod {
        public Set<String> createUnmodifiableSet() {
            return Set.of("I'm", "an", "unmodifiable", "set");
        }
    }

    public static void main(String[] args) {
        new SetDemo().demo();
    }

    private void demo() {
        System.out.println(new CreateUnmodifiableSetVeryOldWay().createUnmodifiableSet());
        System.out.println(new CreateUnmodifiableSetByArraysAsList().createUnmodifiableSet());
        System.out.println(new CreateUnmodifiableSetByStream().createUnmodifiableSet());
        System.out.println(new CreateUnmodifiableSetByFabricMethod().createUnmodifiableSet());
    }
}
