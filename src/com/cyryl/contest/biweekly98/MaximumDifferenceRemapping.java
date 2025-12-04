package com.cyryl.contest.biweekly98;

public class MaximumDifferenceRemapping {
    public int minMaxDifference(int num) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 10; i++) {
            int minResult = 0;
            int maxResult = 0;
            int factor = 1;
            int numHelper = num;
            while (numHelper > 0) {
                int digit = (numHelper % 10);
                int maxDigit = digit;
                int minDigit = digit;
                if(digit == i) {
                    maxDigit = 9;
                    minDigit = 0;
                }
                minResult += minDigit * factor;
                maxResult += maxDigit * factor;
                numHelper = numHelper / 10;
                factor = factor * 10;
            }
            min = Math.min(min, minResult);
            max = Math.max(max, maxResult);
        }
        return max - min;
    }
}
