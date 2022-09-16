package com.cyryl.daily.previous;

import java.util.ArrayList;
import java.util.List;

public class WordSubsets {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] total = new int[26];
        int[] current;
        for (String word : words2) {
            current = new int[26];
            for (int i = 0; i < word.length(); i++) {
                int currChar = word.charAt(i) - 'a';
                current[currChar]++;
                total[currChar] = Math.max(total[currChar], current[currChar]);
            }
        }
        List<String> result = new ArrayList<>();

        for (String word : words1) {
            current = new int[26];
            for (int i = 0; i < word.length(); i++) {
                int currChar = word.charAt(i) - 'a';
                current[currChar]++;
            }
            if (isUniversal(current, total)) {
                result.add(word);
            }
        }
        return result;
    }

    public boolean isUniversal(int[] freq, int[] totalFreq) {
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] < totalFreq[i]) {
                return false;
            }
        }
        return true;
    }
}
