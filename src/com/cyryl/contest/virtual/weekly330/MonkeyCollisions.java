package com.cyryl.contest.virtual.weekly330;

public class MonkeyCollisions {
    public int monkeyMove(int n) {
        final int MOD = (int)1e9 + 7;
        long result = 1;
        long factor = 2;
        while (n > 0) {
            if(n % 2 == 1) {
                result = result * factor % MOD;
            }
            factor = factor * factor % MOD;
            n = n >> 1;
        }
        result = result - 2;
        if(result < 0) {
            result += MOD;
        }
        return (int)result;
    }
}
