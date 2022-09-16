package com.cyryl.daily.previous;

import java.util.*;

/* It passed the tests but the idea was to compare whole dictionary to
    word at the same time, because given String can be very long
 */

public class MatchingSubsequenceV3 {
    private final int NR_OF_LETTERS = 26;

    public int numMatchingSubseq(String s, String[] words) {
        int[][] next = new int[s.length() + 1][NR_OF_LETTERS];

        Map<Integer, Deque<Integer>> chars = new HashMap<>();
        for (int i = 0; i <= s.length(); i++) {
            int curChar = charToInt(s.charAt(i));
            chars.putIfAbsent(curChar, new ArrayDeque<>());
            chars.get(curChar).offer(i + 1);
        }

        for (int i = 0; i < NR_OF_LETTERS; i++) {
            if (chars.containsKey(i)) {
                next[0][i] = chars.get(i).pollLast();
            }
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < NR_OF_LETTERS; j++) {
                if (next[i - 1][j] > i || next[i - 1][j] == 0) {
                    next[i][j] = next[i - 1][j];
                } else if (!chars.get(j).isEmpty()) {
                    next[i][j] = chars.get(j).pollLast();
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
