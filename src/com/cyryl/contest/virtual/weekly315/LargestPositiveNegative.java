package com.cyryl.contest.virtual.weekly315;

import java.util.HashSet;
import java.util.Set;

// 2441.
public class LargestPositiveNegative {
    public int findMaxK(int[] nums) {
        Set<Integer> numbers = new HashSet<>();
        for (int num : nums) {
            if (num < 0) {
                numbers.add(num * -1);
            }
        }
        int max = -1;
        for (int num : nums) {
            if(num > 0 && numbers.contains(num)){
                max = Math.max(max, num);
            }
        }
        return max;
    }
}
