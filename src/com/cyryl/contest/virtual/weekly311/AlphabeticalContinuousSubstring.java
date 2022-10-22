package com.cyryl.contest.virtual.weekly311;

public class AlphabeticalContinuousSubstring {
    public int longestContinuousSubstring(String s) {
        int count = 1;
        int max = 1;
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == s.charAt(i-1) + 1){
                count++;
                max = Math.max(max, count);
            } else {
                count = 1;
            }
        }
        return max;
    }
}
