package com.cyryl.daily.december;

import java.util.Set;

public class NumberOfBeautifulPartitions {
    private final static int MOD = (int) 1e9 + 7;
    private static final Set<Integer> primeDigits = Set.of(2, 3, 5, 7);

    public int beautifulPartitions(String s, int maxK, int minLength) {
        int[] digits = s.chars().map(i -> i - '0').toArray();
        long[][] memo = new long[digits.length + 1][maxK + 1];

        memo[digits.length][0] = 1;
        for (int k = 1; k <= maxK; k++) {
            long totalSum = 0;
            for (int idx = digits.length - minLength; idx >= 0 ; idx--) {
                int possiblePartition = idx + minLength;
                if(!isPrime(digits[possiblePartition - 1])) {
                    totalSum += memo[possiblePartition][k - 1] % MOD;
                }
                if(isPrime(digits[idx])) {
                    memo[idx][k] = totalSum;
                }
            }
        }
        return (int) memo[0][maxK];
    }

    private boolean isPrime(int digit) {
        return primeDigits.contains(digit);
    }
}
