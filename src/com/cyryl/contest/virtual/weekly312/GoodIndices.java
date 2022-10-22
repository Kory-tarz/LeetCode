package com.cyryl.contest.virtual.weekly312;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GoodIndices {
    public List<Integer> goodIndices(int[] nums, int k) {
        int[] nonIncreasing = new int[nums.length];
        int[] nonDecreasing = new int[nums.length];

        Arrays.fill(nonDecreasing, 1);
        Arrays.fill(nonIncreasing, 1);

        for (int i = 1; i < nums.length; i++) {
            if(nums[i] <= nums[i-1]){
                nonIncreasing[i] = 1 + nonIncreasing[i-1];
            }
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            if(nums[i] <= nums[i+1]){
                nonDecreasing[i] = 1 + nonDecreasing[i+1];
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = k; i < nums.length - k; i++) {
            if(nonDecreasing[i+1] >= k && nonIncreasing[i-1] >= k){
                result.add(i);
            }
        }

        return result;
    }
}
