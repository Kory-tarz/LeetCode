package com.cyryl.daily.august;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Integer, Long> ransomLetters = ransomNote.chars().boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<Integer, Long> magazineLetters = magazine.chars().boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return ransomLetters
                .entrySet()
                .stream()
                .allMatch(entry -> entry.getValue() <= magazineLetters.getOrDefault(entry.getKey(), 0L));
    }
}
