package com.cyryl.neetcode150.slidingwindow;

/**
 * Given two strings s and t of lengths m and n respectively,
 * return the minimum window substring of s such that every character in t
 * (including duplicates) is included in the window. If there is
 * no such substring, return the empty string "".
 * <p>
 * The testcases will be generated such that the answer is unique.
 * <p>
 * A substring is a contiguous sequence of characters within the string.
 * <p>
 * 'A' is not equal to 'a'
 */

public class MinimumWindowSubstring {

    private final int NR_OF_LETTERS = 26;

    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        int[] freqT = setFrequency(t);
        int[] freqS = new int[NR_OF_LETTERS * 2];
        int matchingCount = 0;

        for (int i = 0; i < freqT.length; i++) {
            if (freqT[i] == 0) {
                matchingCount++;
            }
        }

        int left = 0;
        int right = 0;
        int maxLeft = -1;
        int minRight = -1;
        int minLen = s.length() + 1;

        while (right < s.length()) {
            int currChar = charToInt(s.charAt(right));
            freqS[currChar]++;
            if (freqS[currChar] == freqT[currChar]) {
                matchingCount++;
            }
            while (matchingCount == NR_OF_LETTERS * 2) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    maxLeft = left;
                    minRight = right;
                }
                int leftChar = charToInt(s.charAt(left));
                if (freqS[leftChar] == freqT[leftChar]) {
                    matchingCount--;
                }
                freqS[leftChar]--;
                left++;
            }
            right++;
        }
        return maxLeft != -1 ? s.substring(maxLeft, minRight + 1) : "";
    }

    private int[] setFrequency(String str) {
        int[] freq = new int[NR_OF_LETTERS * 2];
        for (int i = 0; i < str.length(); i++) {
            freq[charToInt(str.charAt(i))]++;
        }
        return freq;
    }

    private int charToInt(char c) {
        if (Character.isUpperCase(c)) {
            return c - 'A' + NR_OF_LETTERS;
        } else {
            return c - 'a';
        }
    }
}
