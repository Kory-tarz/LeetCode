package com.cyryl.neetcode150.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] picked = new boolean[nums.length];

        calculate(result, new ArrayList<>(), picked, nums);
        return result;
    }

    private void calculate(List<List<Integer>> result, ArrayList<Integer> permutation, boolean[] picked, int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if(!picked[i]){
                picked[i] = true;
                permutation.add(nums[i]);
                if(permutation.size() == nums.length){
                    result.add(permutation);
                } else {
                    calculate(result, permutation, picked, nums);
                }
                permutation.remove(permutation.size()-1);
                picked[i] = false;
            }
        }
    }
}
