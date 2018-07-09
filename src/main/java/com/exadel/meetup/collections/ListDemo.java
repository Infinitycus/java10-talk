package com.exadel.meetup.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListDemo {

    public static void main(String[] args) {
        List<String> unmodifiableList = createUnmodifiableList();
        System.out.println(unmodifiableList);

        List<String> listFromArray = Arrays.asList("I'm", "an", "unmodifiable", "list");
        System.out.println(listFromArray);

        List<String> listFromStream = Stream.of("I'm", "an", "unmodifiable", "list")
                .collect(Collectors.toList());
        System.out.println(listFromStream);
    }

    private static List<String> createUnmodifiableList() {
        List<String> list = new ArrayList<>();
        list.add("I'm");
        list.add("an");
        list.add("unmodifiable");
        list.add("list");
        return Collections.unmodifiableList(list);
    }
}
