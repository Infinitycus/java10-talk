package com.exadel.meetup.typeinference;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

public class InitializerDemo {

    public static void main(String[] args) throws FileNotFoundException {
        InputStream inputStream = new FileInputStream(new File("pom.xml"));
        System.out.println(inputStream.getClass());

        List<String> names = List.of("Pushkin", "Lermontov");
        System.out.println(names);
    }
}
