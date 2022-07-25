package com.cyryl.neetcode150.slidingwindow;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * You are given a string s and an integer k.
 * You can choose any character of the string and change it to any other uppercase English character.
 * You can perform this operation at most k times.
 * <p>
 * Return the length of the longest substring containing the same letter you can get after performing the above operations.
 */

public class RepeatingCharReplacement {
    public int characterReplacement(String s, int k) {
        int[] letterCount = new int[26];
        int maxLen = 1;
        int currMax = 1;
        int currMaxChar = charToInt(s.charAt(0));
        letterCount[currMaxChar]++;
        int left = 0;
        int right = 1;

        while (right < s.length()) {
            int currChar = charToInt(s.charAt(right));
            letterCount[currChar]++;
            if (letterCount[currChar] > letterCount[currMaxChar]) {
                currMaxChar = currChar;
                currMax = letterCount[currChar];
            } else if (currChar == currMaxChar) {
                currMax = letterCount[currChar];
            }
            while (right - left + 1 - currMax > k) {
                int leftChar = charToInt(s.charAt(left));
                letterCount[leftChar]--;
                if (leftChar == currMaxChar) {
                    currMaxChar = findNewMaxFreqChar(letterCount);
                    currMax = letterCount[currMaxChar];
                }
                left++;
            }
            maxLen = Math.max(right - left + 1, maxLen);
            right++;
        }
        return maxLen;
    }

    private int findNewMaxFreqChar(int[] count) {
        int max = 0;
        int maxLetter = 0;
        for (int letter = 0; letter < count.length; letter++) {
            if (count[letter] > max) {
                max = count[letter];
                maxLetter = letter;
            }
        }
        return maxLetter;
    }

    private int charToInt(char c) {
        return c - 'A';
    }
}
