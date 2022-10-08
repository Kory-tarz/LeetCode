package com.cyryl.daily.october;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/3sum-closest/
 */

public class ClosestSum {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestDistance = Integer.MAX_VALUE;
        int bestSum = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length - 1; i++) {
            int left = i - 1;
            int right = i + 1;
            int localTarget = target - nums[i];
            while (left >= 0 && right < nums.length){
                int curr = nums[left] + nums[right];
                int difference = Math.abs(target - curr - nums[i]);
                if(difference < closestDistance){
                    closestDistance = difference;
                    bestSum = curr + nums[i];
                }
                if(curr < localTarget){
                    right++;
                } else {
                    left--;
                }
            }
        }
        return bestSum;
    }
}
