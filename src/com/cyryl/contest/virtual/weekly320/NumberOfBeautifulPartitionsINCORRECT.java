package com.cyryl.contest.virtual.weekly320;

import java.util.Arrays;
import java.util.Set;

/**
 * I ALWAYS FORGET TO CHECK IF MEMORY IS DEFINED UNAMBIGOUSLY
 */

public class NumberOfBeautifulPartitions {

    private final static int MOD = (int) 1e9 + 7;
    private static final Set<Integer> primeDigits = Set.of(2, 3, 5, 7);
    private final static int UNCHECKED = -2;
    private final static int INVALID = -1;

    public int beautifulPartitions(String s, int k, int minLength) {
        int[] digits = s.chars().map(i -> i - '0').toArray();
        System.out.println(s.length() + " " + digits.length);
        System.out.println(Arrays.toString(digits));
        long[][] memo = new long[s.length()][k];
        for (long[] subMemo : memo) {
            Arrays.fill(subMemo, UNCHECKED);
        }
        long result = helper(memo, digits, 0, 1, minLength, 0, k);
        return result != INVALID ? (int) result : 0;
    }

    public long helper(long[][] memo, int[] digits, int idx, int currLength, int minLength, int k, int maxK) {
        if(idx >= digits.length){
            return k == maxK ? 1 : INVALID; // invalid
        }
        if(currLength == 1 && !primeDigits.contains(digits[idx])){
            return INVALID;
        }
        if(k == maxK - 1){
            return (digits.length - idx) >= minLength ? 1 : INVALID;
        }
        if (memo[idx][k] != UNCHECKED) {
            return memo[idx][k];
        }

        long result = 0;
        if (currLength >= minLength && !primeDigits.contains(digits[idx])) {
            long subResultPartition = helper(memo, digits, idx + 1, 1, minLength, k + 1, maxK);
            if(subResultPartition != INVALID){
                result += subResultPartition % MOD;
            }
        }
        long subResultContinue = helper(memo, digits, idx + 1, currLength + 1, minLength, k, maxK);
        if(subResultContinue != INVALID){
            result += subResultContinue % MOD;
        }
        memo[idx][k] = result == 0 ? INVALID : result;
        System.out.println("IDX: " + idx + " partitions: " + k + " result " + memo[idx][k]);
        return memo[idx][k];
    }
}
