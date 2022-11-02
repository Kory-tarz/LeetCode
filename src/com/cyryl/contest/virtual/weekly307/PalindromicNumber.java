package com.cyryl.contest.virtual.weekly307;

public class PalindromicNumber {
    public String largestPalindromic(String num) {
        int[] digitCount = new int[10];
        for (int i = 0; i < num.length(); i++) {
            digitCount[num.charAt(i) - '0']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 9; i > 0; i--) {
            while (digitCount[i] > 1) {
                sb.append(i);
                digitCount[i] -= 2;
            }
        }
        if (!sb.isEmpty()) {
            while (digitCount[0] > 1) {
                sb.append(0);
                digitCount[0] -= 2;
            }
        }
        int middle = getMaxLeft(digitCount);
        StringBuilder sb2 = new StringBuilder(sb).reverse();
        if(middle != -1){
            sb.append(middle);
        }
        sb.append(sb2);
        return sb.toString();
    }

    private int getMaxLeft(int[] digitCount) {
        for (int i = 9; i >= 0; i--) {
            if(digitCount[i] > 0){
                return i;
            }
        }
        return -1;
    }
}
