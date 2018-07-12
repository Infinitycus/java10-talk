package com.exadel.meetup.depraction;

public class DeprecationDemo {

    public static void main(String[] args) {
        new DeprecationDemo().demo();
    }

    @Deprecated(since = "9", forRemoval = true)
    private void demo() {
        System.out.println("I'm deprecated to use");
    }
}
