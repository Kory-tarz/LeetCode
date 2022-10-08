package com.cyryl.neetcode150.dynamic;

public class BurstBalloons2 {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] numsExtended = new int[n + 2];
        numsExtended[0] = 1;
        numsExtended[n + 1] = 1;
        for (int i = 0; i < nums.length; i++) {
            numsExtended[i + 1] = nums[i];
        }
        int[][] memo = new int[n + 1][n + 1];
        return helper(memo, numsExtended, 1, n);
    }

    public int helper(int[][] memo, int[] nums, int left, int right) {
        if(left > right){
            return 0;
        }
        if (left == right) {
            return nums[left - 1] * nums[left] * nums[right + 1];
        }
        if (memo[left][right] != 0) {
            return memo[left][right];
        }
        int bestPop = 0;
        for (int i = left; i <= right; i++) {
            int pop = helper(memo, nums, left, i - 1) + helper(memo, nums, i + 1, right) + nums[i - 1] * nums[i] * nums[i + 1];
            bestPop = Math.max(bestPop, pop);
        }
        memo[left][right] = bestPop;
        return memo[left][right];
    }
}
