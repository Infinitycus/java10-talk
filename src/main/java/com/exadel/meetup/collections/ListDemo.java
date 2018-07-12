package com.exadel.meetup.collections;

import com.exadel.meetup.Annotations.After;
import com.exadel.meetup.Annotations.Before;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListDemo {

    @Before
    class CreateUnmodifiableListVeryOldWay {
        public List<String> createUnmodifiableList() {
            List<String> list = new ArrayList<>();
            list.add("I'm");
            list.add("an");
            list.add("unmodifiable");
            list.add("list");
            return Collections.unmodifiableList(list);
        }
    }

    @Before
    class CreateUnmodifiableListByArraysAsList {
        public List<String> createUnmodifiableList() {
            return Collections.unmodifiableList(Arrays.asList("I'm", "an", "unmodifiable", "list"));
        }
    }

    @Before
    class CreateUnmodifiableListByStream {
        public List<String> createUnmodifiableList() {
            return Collections.unmodifiableList(
                    Stream.of("I'm", "an", "unmodifiable", "list")
                            .collect(Collectors.toList()));
        }
    }

    @After
    class CreateUnmodifiableListByFabricMethod {
        public List<String> createUnmodifiableList() {
            return List.of("I'm", "an", "unmodifiable", "list");
        }
    }

    public static void main(String[] args) {
        new ListDemo().demo();
    }

    private void demo() {
        System.out.println(new CreateUnmodifiableListVeryOldWay().createUnmodifiableList());
        System.out.println(new CreateUnmodifiableListByArraysAsList().createUnmodifiableList());
        System.out.println(new CreateUnmodifiableListByStream().createUnmodifiableList());
        System.out.println(new CreateUnmodifiableListByFabricMethod().createUnmodifiableList());
    }
}
