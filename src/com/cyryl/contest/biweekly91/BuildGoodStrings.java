package com.cyryl.contest.biweekly91;

public class BuildGoodStrings  {
    public int countGoodStrings(int low, int high, int zeroAmount, int oneAmount) {
        final int MOD = (int)1e9 + 7;
        int[] count = new int[high + 1];
        count[0] = 1;
        long sum = 0;
        for (int i = 1; i <= high ; i++) {
            int zeros = (i - zeroAmount) >= 0 ? count[i - zeroAmount] : 0;
            int ones = (i - oneAmount) >= 0 ? count[i - oneAmount] : 0;
            count[i] = (count[i] + (zeros + ones) % MOD) % MOD;
            if(i >= low){
                sum += count[i] % MOD;
            }
        }
        return (int)sum;
    }
}
