package com.cyryl.daily.october;

import java.util.Arrays;

public class JobScheduleDifficulty {
    public int minDifficulty(int[] jobDifficulty, int d) {
        if (jobDifficulty.length < d) {
            return -1;
        }
        int[][] memo = new int[d][jobDifficulty.length];
        for (int[] dayMemo : memo){
            Arrays.fill(dayMemo, -1);
        }
        return helper(memo, jobDifficulty, 0, d-1);
    }

    private int helper(int[][] memo, int[] jobDifficulty, int idx, int daysLeft) {
        if(daysLeft == 0){
            int max = jobDifficulty[idx];
            for (int i = idx + 1; i < jobDifficulty.length ; i++) {
                max = Math.max(max, jobDifficulty[i]);
            }
            return max;
        }
        if(memo[daysLeft][idx] != -1){
            return memo[daysLeft][idx];
        }
        int max = Integer.MIN_VALUE;
        int result = Integer.MAX_VALUE;

        for (int i = idx; i < jobDifficulty.length - daysLeft; i++) {
            max = Math.max(max, jobDifficulty[i]);
            result = Math.min(result, max + helper(memo, jobDifficulty, i + 1, daysLeft - 1));
        }
        memo[daysLeft][idx] = result;
        return result;
    }
}
