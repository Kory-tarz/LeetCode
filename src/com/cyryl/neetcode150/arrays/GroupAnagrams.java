package com.cyryl.neetcode150.arrays;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 *
 * Other ideas for solution:
 * using arr[26] with char frequencies as key in HashMap
 */

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        return Arrays.stream(strs).
                collect(Collectors.
                        groupingBy(s -> s.
                                chars()
                                .sorted()
                                .boxed()
                                .toList()))
                .values()
                .stream()
                .toList();
    }
    public List<List<String>> groupAnagrams2(String[] strs){
        return Arrays.stream(strs)
                .collect(Collectors
                        .groupingBy(s -> s
                                .chars()
                                .boxed()
                                .collect(Collectors
                                        .groupingBy(Function.identity(), Collectors.counting()))))
                .values()
                .stream()
                .toList();
    }
}
