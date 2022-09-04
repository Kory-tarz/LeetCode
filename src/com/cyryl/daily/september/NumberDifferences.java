package com.cyryl.daily.september;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/numbers-with-same-consecutive-differences/
 */

public class NumberDifferences {
    public int[] numsSameConsecDiff(int n, int k) {
        Set<Integer> result = new HashSet<>();

        for (int i = 1; i <= 9; i++) {
            createNum(result, new StringBuilder(String.valueOf(i)), i, n - 1, k);
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    public void createNum(Set<Integer> result, StringBuilder number, int prevDigit, int length, int diff) {
        if (length == 0) {
            result.add(Integer.parseInt(number.toString()));
            return;
        }
        if (prevDigit + diff < 10) {
            createNum(result, new StringBuilder(number).append(prevDigit + diff), prevDigit + diff, length - 1, diff);
        }
        if (prevDigit - diff >= 0) {
            number.append(prevDigit - diff);
            createNum(result, number, prevDigit - diff, length - 1, diff);
        }
    }
}
