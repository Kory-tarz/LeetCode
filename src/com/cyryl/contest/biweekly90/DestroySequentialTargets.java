package com.cyryl.contest.biweekly90;

import java.util.HashMap;
import java.util.Map;

public class DestroySequentialTargets {
    public int destroyTargets(int[] nums, int space) {
        Map<Integer, Integer> numCount = new HashMap<>();
        for (int num : nums) {
            int modDiff = num % space;
            numCount.put(modDiff, numCount.getOrDefault(modDiff, 0) + 1);
        }
        int nrToDestroy = 0;
        for (int val : numCount.values()) {
            nrToDestroy = Math.max(nrToDestroy, val);
        }
        int minSeed = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int mod = nums[i] % space;
            if(numCount.get(mod) == nrToDestroy){
                minSeed = Math.min(minSeed, nums[i]);
            }
        }
        return minSeed;
    }

}
