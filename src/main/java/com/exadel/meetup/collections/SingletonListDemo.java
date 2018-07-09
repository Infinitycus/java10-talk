package com.exadel.meetup.collections;

import com.google.common.collect.ImmutableList;

import java.util.Collections;
import java.util.List;

public class SingletonListDemo {

    public static void main(String[] args) {
        processElements(Collections.singletonList("I'm alone in the list"));
        processElements(ImmutableList.of("I'm not alone in the list", "I'm here as well"));
    }

    private static void processElements(List<String> elements) {
        elements.forEach(System.out::println);
    }
}
