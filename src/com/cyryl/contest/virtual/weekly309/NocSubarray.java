package com.cyryl.contest.virtual.weekly309;

public class NocSubarray {
    public int longestNiceSubarray(int[] nums) {
        int[] bitCount = new int[30];
        int left = 0;
        int right = 0;
        int maxLen = 1;
        while (right < nums.length){
            addNumber(bitCount, nums[right]);
            while (!isValidSubarray(bitCount)){
                removeNumber(bitCount, nums[left]);
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right ++;
        }
        return maxLen;
    }

    private void addNumber(int[] bitCount, int number) {
        int bit = 0;
        while (number > 0) {
            bitCount[bit] += (number & 1) != 0 ? 1 : 0;
            bit++;
            number = number >> 1;
        }
    }

    private void removeNumber(int[] bitCount, int number) {
        int bit = 0;
        while (number > 0) {
            bitCount[bit] -= (number & 1) != 0 ? 1 : 0;
            bit++;
            number = number >> 1;
        }
    }

    private boolean isValidSubarray(int[] bitCount){
        for (int i : bitCount) {
            if(i > 1){
                return false;
            }
        }
        return true;
    }
}
