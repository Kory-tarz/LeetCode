package com.cyryl.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartitionSum {

    boolean[] visited;

    public boolean canPartitionKSubsets(int[] nums, int k) {

        int sum = 0;
        int n = nums.length;
        visited = new boolean[n];

        for(int num : nums)
            sum += num;

        if(sum%k != 0)
            return false;

        Arrays.sort(nums);

        return fillSubset(nums, n-1, 0, sum/k, k);

    }

    private boolean fillSubset(int[] nums, int start, int currSum, int target, int k){

        if(k==0)
            return true;

        if(currSum == target && fillSubset(nums, nums.length-1, 0, target, k-1))
            return true;

        for(int i=start; i>=0; i--){

            if(!visited[i] && nums[i] + currSum <= target) {
                visited[i] = true;
                if(!fillSubset(nums, i-1, currSum+nums[i], target, k))
                    visited[i] = false;
                else
                    return true;
            }
        }
        return false;
    }
}
