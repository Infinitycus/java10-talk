package com.exadel.meetup.typeinference;

import static com.exadel.meetup.typeinference.ResultUtils.generateResults;

import com.exadel.meetup.Annotations.After;
import com.exadel.meetup.Annotations.Before;

import java.util.stream.Stream;

public class NameDemo {

    @Before
    class NameIsBad {
        public void printAnyResultGreaterThen70() {
            Stream<ResultHolder> stream = generateResults().stream();
            stream.filter(NameDemo::isGreaterThen70)
                    .findAny()
                    .ifPresentOrElse(
                            result -> System.out.println("We have result greater then 70 - " + result.getName()),
                            () -> System.out.println("We don't have result greater then 70")
                    );
        }
    }

    @After
    class NameIsGood {
        public void printAnyResultGreaterThen70() {
            var results = generateResults().stream();
            results.filter(NameDemo::isGreaterThen70)
                    .findAny()
                    .ifPresentOrElse(
                            result -> System.out.println("We have result greater then 70 - " + result.getName()),
                            () -> System.out.println("We don't have result greater then 70")
                    );
        }
    }

    public static void main(String[] args) {
        new NameDemo().demo();
    }

    private void demo() {
        new NameIsBad().printAnyResultGreaterThen70();
        new NameIsGood().printAnyResultGreaterThen70();
    }

    private static boolean isGreaterThen70(ResultHolder result) {
        return result.getTotal() > 70;
    }
}
