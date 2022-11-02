package com.cyryl.daily.october;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiFunction;

public class UniqueConcatenation {
    public int maxLength(List<String> arr) {
        int[] characters = new int[26];
        return helper(arr, 0, characters);
    }

    public int helper(List<String> arr, int idx, int[] characters) {
        if (idx >= arr.size()) {
            int count = 0;
            for (int character : characters) {
                if (character > 0) {
                    count++;
                }
            }
            return count;
        }
        int pick = 0;
        if (possibleConcat(characters, arr.get(idx))) {
            updateWord(characters, arr.get(idx), Integer::sum);
            pick = helper(arr, idx + 1, characters);
            updateWord(characters, arr.get(idx), (a, b) -> a - b);
        }
        int dont = helper(arr, idx + 1, characters);
        return Math.max(pick, dont);
    }

    private void updateWord(int[] characters, String word, BiFunction<Integer, Integer, Integer> function) {
        for (int i = 0; i < word.length(); i++) {
            characters[word.charAt(i) - 'a'] = function.apply(characters[word.charAt(i)], 1);
        }
    }

    private boolean possibleConcat(int[] characters, String word) {
        Set<Character> itself = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            if (characters[word.charAt(i) - 'a'] > 0 || itself.contains(word.charAt(i))) {
                return false;
            }
            itself.add(word.charAt(i));
        }
        return true;
    }
}
