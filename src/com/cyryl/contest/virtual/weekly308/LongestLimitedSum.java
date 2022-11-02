package com.cyryl.contest.virtual.weekly308;

import java.util.Arrays;

public class LongestLimitedSum {
    public int[] answerQueries(int[] nums, int[] queries) {
        int[] result = new int[queries.length];
        Arrays.sort(nums);
        for (int i = 0; i < queries.length; i++) {
            int sum = 0;
            int idx = 0;
            while (idx < nums.length && sum + nums[idx] <= queries[i]) {
                sum += nums[idx];
                idx++;
            }
            result[i] = idx;
        }
        return result;
    }
}
