package com.cyryl.daily.year2025.december;

import java.util.Arrays;
import java.util.Collections;

public class RunningComputers {
    public long maxRunTime(int n, int[] batteries) {
        batteries = Arrays.stream(batteries)
                .boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
        long totalPower = 0;
        long extraPower = 0;
        for (int i = 0; i < batteries.length; i++) {
            totalPower += batteries[i];
            if (i >= n) {
                extraPower += batteries[i];
            }
        }
        long maxPower = totalPower / n;
        long low = 0;
        long high = maxPower;
        while (low < high) {
            long goal = (low + high + 1) / 2;
            if (isEnoughPower(goal, n, batteries, extraPower)) {
                low = goal;
            } else {
                high = goal - 1;
            }
        }
        return low;
    }

    private boolean isEnoughPower(long goal, int n, int[] batteries, long extraPower) {
        long missingPower = 0;
        for (int i = 0; i < n; i++) {
            if (batteries[i] < goal) {
                missingPower += goal - batteries[i];
            }
        }
        System.out.println("Goal: " + goal + " Missing: " + missingPower + " Extra: " + extraPower);
        return extraPower >= missingPower;
    }
}
