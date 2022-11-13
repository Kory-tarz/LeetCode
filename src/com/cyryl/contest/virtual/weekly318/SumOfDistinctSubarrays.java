package com.cyryl.contest.virtual.weekly318;

import java.util.HashSet;
import java.util.Set;

public class SumOfDistinctSubarrays {
    public long maximumSubarraySum(int[] nums, int k) {
        long sum = 0;
        int left = 0;
        int right = 0;
        long maxSum = 0;
        Set<Integer> currentNumbers = new HashSet<>();
        while (right < nums.length) {
            while (right < nums.length && (right - left + 1) <= k && !currentNumbers.contains(nums[right])) {
                sum += nums[right];
                currentNumbers.add(nums[right]);
                right++;
            }
            if ((right - left + 1) > k) {
                maxSum = Math.max(sum, maxSum);
                currentNumbers.remove(nums[left]);
                sum -= nums[left];
                left++;
            } else if (right < nums.length) {
                do {
                    currentNumbers.remove(nums[left]);
                    sum -= nums[left];
                    left++;
                } while (nums[left - 1] != nums[right]);
            }
        }
        return maxSum;
    }
}
