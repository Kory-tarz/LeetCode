package com.cyryl.daily.year2023.november;

import java.util.Arrays;

public class Frequency {
    public int maxFrequency(int[] nums, int k) {
        if (nums.length <= 1) {
            return 1;
        }
        Arrays.sort(nums);
        int left = 0;
        int right = 1;
        int bestDiff = 0;
        int currDiff = 0;
        while (right < nums.length) {
            currDiff += ((nums[right] - nums[right - 1]) * (right - left));
            while (currDiff > k) {
                left++;
                currDiff -= ((nums[left] - nums[left - 1]) * (right - left + 1));
            }
            bestDiff = Math.max(bestDiff, right - left + 1);
            right++;
        }
        return bestDiff;
    }
}
