package com.cyryl.contest.biweekly97;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class MaximumNumberFromRange {
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> bannedSet = Arrays.stream(banned).boxed().collect(Collectors.toSet());
        int sum = 0;
        int count = 1;
        for (int i = 1; i <= n; i++) {
            if(bannedSet.contains(i)) {
                continue;
            }
            sum += i;
            if(sum > maxSum) {
                return count;
            }
            count++;
        }
        return count;
    }
}
