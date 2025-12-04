package com.cyryl.daily.year2025.november;

public class VisibleSticks {

    private static final int MOD = (int) 1e9 + 7;

    public int rearrangeSticks(int n, int k) {
        long[][] mem = new long[n + 1][k + 1];
        mem[0][0] = 1;
        for (int currN = 1; currN <= n; currN++) {
            for (int currK = 1; currK <= k && currK <= currN; currK++) {
                if (currK == currN) {
                    mem[currN][currK] = 1;
                } else {
                    mem[currN][currK] = (mem[currN - 1][currK - 1] + mem[currN - 1][currK] * (currN - 1)) % MOD;
                }
            }
        }
        return (int) mem[n][k];
    }
}
