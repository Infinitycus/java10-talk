package com.exadel.meetup.typeinference;

import static java.util.stream.Collectors.counting;

import com.google.common.base.Splitter;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NestedChainDemo {

    public static void main(String[] args) {
        var words = generateWords();

        var result = words.stream()
                .collect(Collectors.groupingBy(word -> word, counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);

        System.out.println(result.orElseThrow());
    }

    private static List<String> generateWords() {
        var song = "Well she drew out all her money out from southern trust" +
                "And put a little boy aboard a greyhound bus" +
                "Leaving Lousiana for the golden west" +
                "Down came her tears from her happiness" +
                "Her own little son named Johnny B Goode" +
                "Was gonna make some motion pictures out in Hollywood" +
                "Bye bye bye bye" +
                "Bye bye bye bye" +
                "Bye bye Johnny bye bye Johnny B Goode" +
                "Well she remember taking money out from gathering crops" +
                "And buying Johnny's guitar at a broker shop" +
                "As long as he could play it by the railroad side" +
                "And wouldn't get in trouble she'd be satisfied" +
                "Never thought there'd ever come a day like this" +
                "When she would gladly give her son a goodbye kiss" +
                "Bye bye bye bye" +
                "Bye bye bye bye" +
                "Bye bye Johnny bye bye Johnny B Goode" +
                "Well she finally got the letter she was dreaming of" +
                "Johnny wrote and told her he had fell in love" +
                "As soon as he was married he would bring her back" +
                "And build a mansion for her by the railroad tracks" +
                "And everytime they heard the locomotive roar" +
                "They'd be a standing, waving in the kitchen door" +
                "Howling bye bye bye bye" +
                "Now bye bye bye bye" +
                "Bye bye Johnny bye bye Johnny B Goode";

        return Splitter.on(" ")
                .trimResults()
                .omitEmptyStrings()
                .splitToList(song);
    }
}
