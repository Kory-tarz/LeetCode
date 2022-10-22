package com.cyryl.contest.virtual.weekly311;

public class SmallestEvenMultiple {
    public int smallestEvenMultiple(int n) {
        return n % 2 == 0 ? n : 2 * n;
    }
}
