package com.cyryl.contest.virtual.weekly315;

import java.util.HashSet;
import java.util.Set;

// 2442
public class DistinctIntegersAfterReverse {
    public int countDistinctIntegers(int[] nums) {
        Set<Integer> distinctNums = new HashSet<>();
        for (int num : nums){
            distinctNums.add(num);
            String reversedNumber = new StringBuilder(String.valueOf(num)).reverse().toString();
            distinctNums.add(Integer.valueOf(reversedNumber.replaceAll("^0*", "")));
        }
        return distinctNums.size();
    }
}
