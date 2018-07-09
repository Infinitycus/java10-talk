package com.exadel.meetup.typeinference;

import java.util.ArrayList;
import java.util.List;

public class DiamondDemo {

    public static void main(String[] args) {
        List<String> listOfStrings = new ArrayList<>();
        listOfStrings.add("1");
        listOfStrings.add("2");
//        listOfStrings.add(3);
        System.out.println(listOfStrings.get(0).getClass());
        System.out.println(listOfStrings.get(1).getClass());

        processElements(listOfStrings);
    }

    private static void processElements(List<String> listOfStrings) {
        listOfStrings.forEach(System.out::println);
    }
}
