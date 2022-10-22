package com.cyryl.contest.virtual.weekly312;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class SortThePeople {
    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer, String> heightsOfPeople = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            heightsOfPeople.put(heights[i], names[i]);
        }
        heights = Arrays.stream(heights).boxed().sorted((a,b)->b-a).mapToInt(i->i).toArray();
        for (int i = 0; i < heights.length; i++) {
            names[i] = heightsOfPeople.get(heights[i]);
        }
        return names;
    }
}
