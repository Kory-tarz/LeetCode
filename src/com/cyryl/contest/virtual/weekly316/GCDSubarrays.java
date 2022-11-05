package com.cyryl.contest.virtual.weekly316;

public class GCDSubarrays {
    public int subarrayGCD(int[] nums, int k) {
        int count = 0;
        for (int left = 0; left < nums.length; left++) {
            if (nums[left] == k) {
                count++;
            }
            if (left == nums.length - 1) {
                continue;
            }
            int right = left + 1;
            int gcd = nums[left];
            while (right < nums.length) {
                gcd = gcd(gcd, nums[right]);
                if(gcd == k){
                    count++;
                }
                right++;
            }
        }
        return count;
    }

    public int gcd(int a, int b) {
        if(a == 0){
            return b;
        }
        return gcd(b % a, a);
    }
}
