package com.cyryl.neetcode150.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        calculateResult(candidates, result, new ArrayList<>(), 0, 0, target);
        return result;
    }

    private void calculateResult(int[] candidates, List<List<Integer>> result, List<Integer> combination, int curr, int sum, int target) {
        if(sum > target || curr >= candidates.length){
            return;
        }
        if(sum == target){
            result.add(new ArrayList<>(combination));
            return;
        }
        // pick
        combination.add(candidates[curr]);
        calculateResult(candidates, result, combination, curr, sum + candidates[curr], target);
        combination.remove(combination.size() - 1);
        // don't pick
        calculateResult(candidates, result, combination, curr + 1, sum, target);
    }
}
