package com.cyryl.medium;

import java.util.Arrays;
import java.util.Comparator;

public class EqualArrayElements {
    public int minMoves2(int[] nums) {
        double avg = Arrays.stream(nums).average().orElse(0);
        int floor = (int)Math.floor(avg);
        int ceiling = (int)Math.ceil(avg);
        int floorSum = 0;
        int ceilSum = 0;

        for (int i = 0; i < nums.length; i++) {
            floorSum += Math.abs(nums[i] - floor);
            ceilSum += Math.abs(nums[i] - ceiling);
        }
        return Math.min(floorSum, ceilSum);
    }

}
