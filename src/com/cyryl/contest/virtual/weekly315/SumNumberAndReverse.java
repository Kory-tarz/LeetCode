package com.cyryl.contest.virtual.weekly315;

public class SumNumberAndReverse {
    public boolean sumOfNumberAndReverse(int num) {
        for (int i = 0; i <= num / 2; i++) {
            int big = num - i;
            String revBig = new StringBuilder(String.valueOf(big)).reverse().toString();
            if (Integer.parseInt(revBig) == i) {
                return true;
            }
        }
        return false;
    }
}
