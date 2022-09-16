package com.cyryl.daily.previous;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

/**
 * https://leetcode.com/problems/combination-sum-iv/
 */

public class CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        int[] memo = new int[target + 1];
        memo[0] = 1;

        for (int currTarget = 1; currTarget <= target; currTarget++) {
            for (int i = 0; i < nums.length; i++) {
                if(currTarget >= nums[i]){
                    memo[currTarget] += memo[currTarget-nums[i]];
                }
            }
        }
        return memo[target];
    }
}
