package com.exadel.meetup.typeinference;

import static java.util.stream.Collectors.groupingBy;

import java.util.List;
import java.util.Map;

public class InitialDemo {

    public static void main(String[] args) {
        Map<String, List<ResultHolder>> resultsByGroup = ResultUtils.generateResults()
                .stream()
                .collect(groupingBy(ResultHolder::getGroupName));
        System.out.println(resultsByGroup);
    }

}
