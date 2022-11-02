package com.cyryl.contest.virtual.biweekly86;

import java.util.HashSet;
import java.util.Set;

public class SubarraysWithEqualSum {
    public boolean findSubarrays(int[] nums) {
        Set<Integer> sums = new HashSet<>();
        for (int i = 1; i < nums.length; i++) {
            int sum = nums[i] + nums[i-1];
            if(sums.contains(sum)){
                return true;
            }
            sums.add(sum);
        }
        return false;
    }
}
