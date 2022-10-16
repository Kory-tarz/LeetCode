package com.cyryl.contest.biweekly89;

public class MinimizeMax {
    public int minimizeArrayValue(int[] nums) {
        long sum = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++){
            int currSum = nums[i] + nums[i-1];
            sum += nums[i];
            int currMax = sum % (i+1) == 0 ? (int)(sum / (i+1)) : (int)(sum /(i+1) + 1);
            System.out.println(currMax);
            max = Math.max(max, currMax);
            if(currSum <= max){
                nums[i-1] = currSum;
                nums[i] = 0;
            } else {
                nums[i-1] = max;
                nums[i] = currSum - max;
            }
        }
        return max;
    }
}
