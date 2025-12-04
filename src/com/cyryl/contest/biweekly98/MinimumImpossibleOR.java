package com.cyryl.contest.biweekly98;

import java.util.HashSet;
import java.util.Set;

public class MinimumImpossibleOR {
    public int minImpossibleOR(int[] nums) {
        boolean[] bit = new boolean[32];
        Set<Integer> numbers = new HashSet<>();
        for (int num : nums) {
            int curr = num;
            numbers.add(num);
            int pos = 0;
            while (curr > 0) {
                if((curr & 1) == 1) {
                    bit[pos] = true;
                }
                curr = curr >> 1;
                pos++;
            }
        }
        for (int i = 0; i < bit.length; i++) {
            if(!bit[i] || !numbers.contains(1 << i)) {
                return 1 << i;
            }
        }
        return -1;
    }
}
