package com.cyryl.contest.virtual.weekly314;

// 2433
public class OriginalPrefix {
    public int[] findArray(int[] pref) {
        int[] orig = new int[pref.length];
        orig[0] = pref[0];
        for (int i = 1; i < pref.length; i++) {
            orig[i] = pref[i] ^ pref[i - 1];
        }
        return orig;
    }
}
