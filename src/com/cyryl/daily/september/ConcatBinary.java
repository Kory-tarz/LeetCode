package com.cyryl.daily.september;

import java.util.ArrayDeque;

public class ConcatBinary {

    private final static long MOD = (int) 1e9 + 7;

    public int concatenatedBinary(int n) {
        long res = 0;
        int digits = 0;

        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                digits++;
            }
            res = ((res << digits) + i) % MOD;
        }
        return (int)res;
    }
}
