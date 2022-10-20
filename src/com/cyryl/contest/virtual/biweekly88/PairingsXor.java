package com.cyryl.contest.virtual.biweekly88;

public class PairingsXor {
    public int xorAllNums(int[] a, int[] b) {
        boolean aEven = a.length % 2 == 0;
        boolean bEven = b.length % 2 == 0;

        int sum = 0;
        if(!aEven){
            for (int numb : b){
                sum = sum ^ numb;
            }
        }
        if(!bEven){
            for (int numa : a){
                sum = sum ^ numa;
            }
        }
        return sum;
    }
}
