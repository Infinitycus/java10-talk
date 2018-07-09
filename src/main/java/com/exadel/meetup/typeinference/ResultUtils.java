package com.exadel.meetup.typeinference;

import java.util.List;

public class ResultUtils {

    public static List<ResultHolder> generateResults() {
        return List.of(
                new ResultHolder("M-22", "Chuck", 50),
                new ResultHolder("M-22", "Arnold", 20),
                new ResultHolder("M-21", "Bruce", 75),
                new ResultHolder("M-23", "Alice", 50),
                new ResultHolder("M-23", "Silvester", 35)
        );
    }
}
