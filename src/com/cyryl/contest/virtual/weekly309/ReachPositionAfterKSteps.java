package com.cyryl.contest.virtual.weekly309;

public class ReachPositionAfterKSteps {
    public int numberOfWays(int startPos, int endPos, int k) {
        final int MOD = (int)1e9 + 7;
        int shift = 1_000;
        int[][] memo = new int[3 * shift + 2][k + 1];
        startPos += shift;
        endPos += shift;
        memo[endPos][0] = 1;
        for (int currK = 1; currK <= k; currK++) {
            for (int i = 1; i < memo.length - 1; i++) {
                memo[i][currK] = (memo[i + 1][currK - 1] + memo[i-1][currK - 1]) % MOD;
            }
        }
        return memo[startPos][k];
    }
}
