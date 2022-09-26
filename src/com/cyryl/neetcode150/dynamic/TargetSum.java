package com.cyryl.neetcode150.dynamic;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class TargetSum {
    public int findTargetSumWays2(int[] nums, int target) {
        Map<Integer, Map<Integer, Integer>> memo = new HashMap<>();
        return helper(memo, nums, target, 0, 0);
    }

    private int helper(Map<Integer, Map<Integer, Integer>> memo, int[] nums, int target, int idx, int sum) {
        if (idx >= nums.length) {
            return sum == target ? 1 : 0;
        }
        if (memo.containsKey(sum) && memo.get(sum).containsKey(idx)) {
            return memo.get(sum).get(idx);
        }
        int count = helper(memo, nums, target, idx + 1, sum + nums[idx]);
        count += helper(memo, nums, target, idx + 1, sum - nums[idx]);
        memo.putIfAbsent(sum, new HashMap<>());
        memo.get(sum).put(idx, count);
        return count;
    }

    public int findTargetSumWays(int[] nums, int target) {
        Map<Integer, Integer> sumCount = new HashMap<>();
        sumCount.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            Map<Integer, Integer> nextSumCount = new HashMap<>();
            for (Map.Entry<Integer, Integer> entry : sumCount.entrySet()) {
                int nextSumPos = entry.getKey() + nums[i];
                int countPos = nextSumCount.getOrDefault(nextSumPos, 0);
                int nextSumNeg = entry.getKey() - nums[i];
                int countNeg = nextSumCount.getOrDefault(nextSumNeg, 0);
                nextSumCount.put(nextSumPos, countPos + entry.getValue());
                nextSumCount.put(nextSumNeg, countNeg  + entry.getValue());
            }
            sumCount = nextSumCount;
        }
        return sumCount.getOrDefault(target, 0);
    }
}
