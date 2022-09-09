package com.cyryl.coderbyte;

public class MinWindow {

    private static final int LETTERS_IN_ALPHABET = 26;

    public static String MinWindowSubstring(String[] strArr) {
        String word = strArr[0];
        String pattern = strArr[1];

        int[] patternFreq = new int[LETTERS_IN_ALPHABET];
        for (int i = 0; i < pattern.length(); i++) {
            patternFreq[pattern.charAt(i) - 'a']++;
        }

        int[] wordFreq = new int[LETTERS_IN_ALPHABET];
        int left = 0;
        int right = 1;

        int bestLen = word.length();
        int bestLeft = 0;
        int bestRight = word.length() - 1;

        while (right <= word.length()) {
            if (containsFreq(wordFreq, patternFreq)) {
                if (right - left < bestLen) {
                    bestLeft = left;
                    bestRight = right;
                    bestLen = right - left;
                }
                wordFreq[word.charAt(left) - 'a']--;
                left++;
            } else {
                wordFreq[word.charAt(right - 1) - 'a']++;
                right++;
            }
        }
        return word.substring(bestLeft, bestRight);
    }

    public static boolean containsFreq(int[] main, int[] sub) {
        for (int i = 0; i < main.length; i++) {
            if (main[i] < sub[i]) {
                return false;
            }
        }
        return true;
    }
}
