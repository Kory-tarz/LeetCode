package com.cyryl.contest.virtual.weekly316;

public class MakeArrayEqual {
    public long minCost(int[] nums, int[] cost) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        while (min < max) {
            int mid = (min + max) / 2;
            long midCost = calcCost(mid, nums, cost);
            long midLess = calcCost(mid - 1, nums, cost);
            long midMore = calcCost(mid + 1, nums, cost);
            if (midLess >= midCost && midMore >= midCost) {
                return midCost;
            }
            if (midLess >= midCost) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return calcCost(min, nums, cost);
    }

    public long calcCost(int target, int[] nums, int[] cost) {
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += (long) Math.abs(nums[i] - target) * cost[i];
        }
        return sum;
    }
}
