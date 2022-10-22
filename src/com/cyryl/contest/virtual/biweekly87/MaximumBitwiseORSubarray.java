package com.cyryl.contest.virtual.biweekly87;

import java.util.Arrays;

public class MaximumBitwiseORSubarray {

    private final static int BITS = 31;

    public int[] smallestSubarrays(int[] nums) {
        int[][] closestBit = new int[nums.length][BITS];
        int[] result = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            int max = 1;
            for (int bit = 0; bit < BITS; bit++) {
                if((nums[i] & (1 << bit)) != 0){
                    closestBit[i][bit] = 1;
                } else if (i + 1 < nums.length && closestBit[i+1][bit] != 0){
                    closestBit[i][bit] = 1 + closestBit[i + 1][bit];
                }
                max = Math.max(max, closestBit[i][bit]);
            }
            result[i] = max;
        }
        return result;
    }
}
