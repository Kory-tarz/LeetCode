package com.cyryl.neetcode150.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets/
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        findSubsets(nums, 0, result, new ArrayList<>());
        return result;
    }

    public void findSubsets(int[] nums, int currNum, List<List<Integer>> result, List<Integer> currSet) {
        if (currNum >= nums.length) {
            result.add(currSet);
            return;
        }
        // pick current
        List<Integer> newSet = new ArrayList<>(currSet);
        newSet.add(nums[currNum]);
        findSubsets(nums, currNum + 1, result, newSet);
        // dont pick
        findSubsets(nums, currNum + 1, result, currSet);
    }

    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < (1 << nums.length); i++) {
            List<Integer> set = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if ((i & (1 << j)) != 0) {
                    set.add(nums[j]);
                }
            }
            result.add(set);
        }
        return result;
    }
}
