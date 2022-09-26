package com.cyryl.neetcode150.dynamic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DistinctSubseq {

    // TLE
    public int numDistinct2(String word, String target) {
        Map<Character, List<String>> charPrefix = new HashMap<>();
        for (int i = 0; i < target.length(); i++) {
            char curr = target.charAt(i);
            charPrefix.putIfAbsent(curr, new ArrayList<>());
            charPrefix.get(curr).add(target.substring(0, i));
        }
        Map<String, Integer> sequenceCount = new HashMap<>();
        sequenceCount.put("", 1);

        for (int i = 0; i < word.length(); i++) {
            char curr = word.charAt(i);
            if (!charPrefix.containsKey(curr)) {
                continue;
            }
            List<String> prefixes = charPrefix.get(curr);
            // iterate from longer words first
            for (int j = prefixes.size() - 1; j >= 0; j--) {
                String newPrefix = prefixes.get(j) + curr;
                int prefixCount = sequenceCount.getOrDefault(prefixes.get(j), 0);
                int newPrefixCount = sequenceCount.getOrDefault(newPrefix, 0);
                sequenceCount.put(newPrefix, prefixCount + newPrefixCount);
            }
        }
        return sequenceCount.getOrDefault(target, 0);
    }

    public int numDistinct(String word, String target) {
        int[][] memo = new int[target.length() + 1][word.length() + 1];
        for (int i = 0; i < word.length(); i++) {
            memo[0][i] = 1;
        }

        for (int i = 0; i < target.length(); i++) {
            for (int j = 0; j < word.length(); j++) {
                if (target.charAt(i) == word.charAt(j)) {
                    memo[i + 1][j + 1] = memo[i][j] + memo[i + 1][j];
                } else {
                    memo[i + 1][j + 1] = memo[i + 1][j];
                }
            }
        }
        return memo[target.length()][word.length()];
    }
}
