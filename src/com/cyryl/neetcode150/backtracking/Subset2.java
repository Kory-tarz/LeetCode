package com.cyryl.neetcode150.backtracking;

import java.util.*;
import java.util.stream.Collectors;

public class Subset2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        calculate(result, new ArrayList<>(), 0, nums);
        return new ArrayList<>(result);
    }

    private void calculate(Set<List<Integer>> result, ArrayList<Integer> subset, int i, int[] nums) {
        if(i == nums.length){
            result.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[i]);
        calculate(result, subset, i + 1, nums);
        subset.remove(subset.size() - 1);
        calculate(result, subset, i + 1, nums);
    }
}
