package com.cyryl.contest.biweekly97;

import java.util.Arrays;

public class MaximizeWin {
    public int maximizeWin(int[] prizePositions, int k) {
        int[] memo = new int[prizePositions.length];
        int start = 0;
        int count = 0;
        int best = 0;
        for (int i = 0; i < prizePositions.length; i++) {
            count++;
            while (prizePositions[i] - prizePositions[start] > k) {
                count--;
                start++;
            }
            best = Math.max(best, count);
            memo[i] = best;
        }
        start = prizePositions.length - 1;
        count = 0;
        int result = 0;
        for (int i = start; i > 0; i--) {
            count++;
            while (prizePositions[start] - prizePositions[i] > k) {
                count--;
                start--;
            }
            result = Math.max(result, memo[i - 1] + count);
        }
        return result;
    }
}
