package com.cyryl.daily.october;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> memory = new HashMap<>();
        memory.put(0, 0);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = (sum + nums[i]) % k;
            if (memory.containsKey(sum)) {
                if (memory.get(sum) < i - 1) {
                    return true;
                }
            } else {
                memory.put(sum, i);
            }
        }
        return false;
    }
}
