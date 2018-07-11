package com.exadel.meetup.stackwalker;

import static java.lang.StackWalker.Option.RETAIN_CLASS_REFERENCE;
import static java.lang.StackWalker.Option.SHOW_HIDDEN_FRAMES;

import com.exadel.meetup.Annotations.Before;

import java.util.Set;

@Before
public class StackWalkerDemo {

    public static void main(String[] args) {
        new StackWalkerDemo().walk();
    }

    private void walk() {
        new Walker1().walk();
    }

    private class Walker1 {
        private void walk() {
            new Walker2().walk();
        }
    }


    private class Walker2 {
        private void walk() {
            oldWay();
            newWay();
        }

        private void oldWay() {
            System.out.println("Before Java 9");

            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            for (StackTraceElement stackTraceElement : stackTrace) {
                System.out.println(stackTraceElement);
            }
        }

        private void newWay() {
            System.out.println("After Java 9");

            StackWalker stackWalker = StackWalker.getInstance(Set.of(RETAIN_CLASS_REFERENCE, SHOW_HIDDEN_FRAMES), 16);
            stackWalker.forEach(System.out::println);
        }
    }

}
