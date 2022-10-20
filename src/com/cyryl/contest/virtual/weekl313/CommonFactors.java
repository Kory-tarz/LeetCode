package com.cyryl.contest.virtual.weekl313;

public class CommonFactors {
    public int commonFactors(int a, int b) {
        int count = 1; // 1 is always a common factor
        for (int i = 2; i <= Math.min(a, b) ; i++) {
            if(a % i == 0 && b % i == 0){
                count++;
            }
        }
        return count;
    }
}
