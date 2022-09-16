package com.cyryl.daily.september;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-score-from-performing-multiplication-operations/
 */

public class PerformingMultiplication {

    // top down solution
    public int maximumScore(int[] nums, int[] multipliers) {
        int m = multipliers.length;
        int[][] memo = new int[m + 1][2];
        for (int op = m - 1; op >= 0; op--) {
            for (int left = op; left >= 0; left--) {
                int right = nums.length - 1 - (op - left);
                memo[left][op % 2] = Math.max(
                        multipliers[op] * nums[left] + memo[left + 1][(op + 1) % 2],
                        multipliers[op] * nums[right] + memo[left][(op + 1) % 2]);
            }
        }
        return memo[0][0];
    }

    // bottom up solution
    // Memory limit exceeded -
    // changed memo from new Integer[nums.length][multipliers.length] to new Integer[multipliers.length][multipliers.length]
    // solution was accepted
    public int maximumScore2(int[] nums, int[] multipliers) {
        Integer[][] memo = new Integer[multipliers.length][multipliers.length];
        return calculate(memo, nums, multipliers, 0, nums.length - 1, 0);
    }

    private int calculate(Integer[][] memo, int[] nums, int[] multipliers, int left, int right, int idx) {
        if (idx >= multipliers.length) {
            return 0;
        }
        if (memo[left][idx] != null) {
            return memo[left][idx];
        }
        int leftResult = nums[left] * multipliers[idx] + calculate(memo, nums, multipliers, left + 1, right, idx + 1);
        int rightResult = nums[right] * multipliers[idx] + calculate(memo, nums, multipliers, left, right - 1, idx + 1);

        memo[left][idx] = Math.max(leftResult, rightResult);
        return memo[left][idx];
    }
}
