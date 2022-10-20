package com.cyryl.contest.virtual.weekly315;

import java.util.Arrays;

// 2444
public class SubarraysWithFixedBounds {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int lastMinIdx = 0, lastMaxIdx = 0;
        boolean minFound = false, maxFound = false;
        int start = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] < minK || nums[i] > maxK){
                maxFound = false;
                minFound = false;
                start = i+1;
                continue;
            }
            if(nums[i] == minK){
                lastMinIdx = i;
                minFound = true;
            }
            if(nums[i] == maxK){
                lastMaxIdx = i;
                maxFound = true;
            }
            if(maxFound && minFound){
                count += Math.min(lastMinIdx, lastMaxIdx) - start + 1;
            }
        }
        return count;
    }
}
