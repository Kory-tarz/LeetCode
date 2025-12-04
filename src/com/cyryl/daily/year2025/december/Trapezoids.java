package com.cyryl.daily.year2025.december;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trapezoids {

    private static final int MOD = (int) 1e9 + 7;

    public int countTrapezoids(int[][] points) {
        Map<Integer, Integer> horizontalCount = new HashMap<>();
        for (int[] point : points) {
            int count = horizontalCount.getOrDefault(point[1], 0);
            horizontalCount.put(point[1], count + 1);
        }
        List<Long> allCombinations = horizontalCount.values().stream()
                .map(count -> ((long)count * (count - 1)) / 2)
                .toList();
        long totalCount = 0;
        long result = 0;
        for (Long currCount : allCombinations) {
            result = (result + (currCount * totalCount) % MOD) % MOD;
            totalCount += currCount;
        }
        return (int) result;
    }
}
