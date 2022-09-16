package com.cyryl.daily.previous;

// TLE

public class MatchingSubsequence {
    public int numMatchingSubseq(String s, String[] words) {
        int count = 0;
        for (String word : words) {
            if(isSubSequence(s, word)){
                count++;
            }
        }
        return count;
    }

    private boolean isSubSequence(String main, String word) {
        if(word.length() > main.length()){
            return false;
        }
        int mainIndex = 0;
        int wordIndex = 0;
        while (mainIndex < main.length() && wordIndex < word.length()) {
            if (main.charAt(mainIndex) == word.charAt(wordIndex)) {
                wordIndex++;
            }
            mainIndex++;
        }
        return wordIndex == word.length();
    }
}
