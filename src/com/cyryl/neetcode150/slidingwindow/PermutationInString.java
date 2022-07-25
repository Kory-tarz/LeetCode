package com.cyryl.neetcode150.slidingwindow;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
 * <p>
 * In other words, return true if one of s1's permutations is the substring of s2.
 */

public class PermutationInString {
    @SuppressWarnings("Duplicates")
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        final int NR_OF_LETTERS = 26;
        int[] freq = new int[NR_OF_LETTERS];
        int[] freqPerm = new int[NR_OF_LETTERS];
        for (int i = 0; i < s1.length(); i++) {
            freq[s1.charAt(i) - 'a']++;
            freqPerm[s2.charAt(i) - 'a']++;
        }
        int matchCount = 0;
        for (int i = 0; i < NR_OF_LETTERS; i++) {
            if (freq[i] == freqPerm[i]){
                matchCount++;
            }
        }
        if(matchCount == NR_OF_LETTERS){
            return true;
        }

        for (int i = s1.length(); i < s2.length(); i++) {
            int newChar = s2.charAt(i) - 'a';
            int lostChar = s2.charAt(i - s1.length()) - 'a';
            if(freq[lostChar] == freqPerm[lostChar]){
                matchCount--;
            }
            if(freq[newChar] == freqPerm[newChar]){
                matchCount--;
            }
            freqPerm[newChar]++;
            freqPerm[lostChar]--;
            if(freqPerm[newChar] == freq[newChar]){
                matchCount++;
            }
            if(freqPerm[lostChar] == freq[lostChar]){
                matchCount++;
            }
            if(matchCount == NR_OF_LETTERS){
                return true;
            }
        }
        return false;
    }

    public boolean isEqualFreq(int[] f1, int[] f2) {
        for (int i = 0; i < f1.length; i++) {
            if (f1[i] != f2[i]) {
                return false;
            }
        }
        return true;
    }

    private int charToInt(char c) {
        return c - 'a';
    }

    @SuppressWarnings("Duplicates")
    public boolean checkInclusion2(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        final int NR_OF_LETTERS = 26;
        int[] freq = new int[NR_OF_LETTERS];
        int[] freqPerm = new int[NR_OF_LETTERS];
        for (int i = 0; i < s1.length(); i++) {
            freq[s1.charAt(i) - 'a']++;
            freqPerm[s2.charAt(i) - 'a']++;
        }
        if (isEqualFreq(freq, freqPerm)) {
            return true;
        }
        for (int i = s1.length(); i < s2.length(); i++) {
            freqPerm[s2.charAt(i) - 'a']++;
            freqPerm[s2.charAt(i - s1.length()) - 'a']--;
            if(isEqualFreq(freq, freqPerm)){
                return true;
            }
        }

        return false;
    }

}
