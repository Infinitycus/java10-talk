package com.exadel.meetup.typeinference;

import static com.exadel.meetup.typeinference.ResultUtils.generateResults;

import java.util.stream.Stream;

public class NameDemo {

    public static void main(String[] args) {
        // NOT OK
        Stream<ResultHolder> stream = generateResults().stream();
        stream.filter(result -> result.getTotal() > 70)
                .findAny()
                .ifPresentOrElse(
                        result -> System.out.println("We have result greater then 70 - " + result.getName()),
                        () -> System.out.println("We don't have result greater then 70")
                );


        // OK
        var results = generateResults().stream();
        results.filter(result -> result.getTotal() > 90)
                .findAny()
                .ifPresentOrElse(
                        result -> System.out.println("We have result greater then 90 - " + result.getName()),
                        () -> System.out.println("We don't have result greater then 90")
                );

    }
}
