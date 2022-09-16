package com.cyryl.daily.september;

import java.util.*;

/**
 * https://leetcode.com/problems/find-original-array-from-doubled-array/
 */

public class OriginalArray {

    private final int MAX_VALUE = (int) 1e5;

    public int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 == 1) {
            return new int[]{};
        }
        List<Integer> original = new ArrayList<>();
        Map<Integer, Integer> numberCount = new HashMap<>();
        Arrays.sort(changed);
        for (int i = changed.length - 1; i >= 0; i--) {
            int doubledValue = changed[i] * 2;
            if (numberCount.containsKey(doubledValue)) {
                int count = numberCount.get(doubledValue) - 1;
                if (count == 0) {
                    numberCount.remove(doubledValue);
                } else {
                    numberCount.put(doubledValue, count);
                }
                original.add(changed[i]);
            } else {
                int count = numberCount.getOrDefault(changed[i], 0) + 1;
                numberCount.put(changed[i], count);
            }
        }
        if (numberCount.size() > 0) {
            return new int[]{};
        } else {
            return original.stream().mapToInt(i -> i).toArray();
        }
    }
}
