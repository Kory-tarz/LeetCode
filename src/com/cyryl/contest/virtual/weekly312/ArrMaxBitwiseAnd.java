package com.cyryl.contest.virtual.weekly312;

public class ArrMaxBitwiseAnd {
    public int longestSubarray(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int len = 0;
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == max){
                len++;
            } else {
                len = 0;
            }
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }
}
