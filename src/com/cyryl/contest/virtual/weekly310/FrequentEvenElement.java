package com.cyryl.contest.virtual.weekly310;

import java.util.HashMap;
import java.util.Map;

public class FrequentEvenElement {
    public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            if (num % 2 == 0) {
                freq.put(num, freq.getOrDefault(num, 0) + 1);
            }
        }
        int maxFreq = 0;
        int result = -1;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() > maxFreq) {
                result = entry.getKey();
                maxFreq = entry.getValue();
            } else if (entry.getValue() == maxFreq) {
                result = Math.min(result, entry.getKey());
            }
        }
        return result;
    }
}
