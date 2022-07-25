package com.cyryl.daily;

public class MatchingSubsequenceV2 {

    private final int NR_OF_LETTERS = 26;

    public int numMatchingSubseq(String s, String[] words) {
        int[][] next = new int[s.length()][NR_OF_LETTERS];

        for (int currentIndex = 0; currentIndex < s.length(); currentIndex++) {
            for (int nextIndex = currentIndex; nextIndex < s.length(); nextIndex++) {
                int currChar = charToInt(s.charAt(nextIndex));
                if (next[currentIndex][currChar] == 0) {
                    next[currentIndex][currChar] = nextIndex + 1;
                }
            }
        }
        int count = 0;
        for (String word : words) {
            if (isSubSequence(next, word)) {
                count++;
            }
        }
        return count;
    }

    private boolean isSubSequence(int[][] pattern, String word) {
        if (word.length() > pattern.length) {
            return false;
        }
        int patternIndex = 0;
        for (int i = 0; i < word.length(); i++) {
            int currChar = charToInt(word.charAt(i));
            patternIndex = pattern[patternIndex][currChar];
            if (patternIndex == 0) {
                return false;
            }
        }
        return true;
    }

    private int charToInt(char c) {
        return c - 'a';
    }
}
