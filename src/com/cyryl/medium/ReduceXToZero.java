package com.cyryl.medium;

import java.util.HashMap;
import java.util.Map;

public class ReduceXToZero {
    public int minOperations(int[] nums, int x) {
        int left = 0;
        int right = nums.length-1;

        Map<Integer, Integer> leftMap = new HashMap<>();
        Map<Integer, Integer> rightMap = new HashMap<>();

        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            leftMap.put(sum, i+1);
        }
        sum = 0;
        for(int i=nums.length-1; i>=0; i--){
            sum += nums[i];
            rightMap.put(sum, nums.length - i);
        }

        int stepCount = 0;
        int currValue = x;
        int min = Integer.MAX_VALUE;
        int tempSteps;
        int leftSum = 0;
        int rightSum = 0;

        while(currValue > 0 && left < right){
            if(leftMap.containsKey(currValue + leftSum)){
                tempSteps = leftMap.get(currValue + leftSum);
                min = Math.min(min, tempSteps - stepCount/2 + stepCount);
            }
            if(rightMap.containsKey(currValue + rightSum)){
                tempSteps = rightMap.get(currValue + rightSum);
                min = Math.min(min, tempSteps - stepCount/2 + stepCount);
            }
            currValue = currValue-nums[left]-nums[right];
            leftSum += nums[left];
            rightSum += nums[right];
            left++;
            right--;
            stepCount += 2;
            if(currValue == 0){
                min = Math.min(min, stepCount);
            }
        }
        return (min == Integer.MAX_VALUE) ? -1: min;
    }
}
