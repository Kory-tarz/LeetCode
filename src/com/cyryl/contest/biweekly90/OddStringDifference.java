package com.cyryl.contest.biweekly90;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OddStringDifference {
    public String oddString(String[] words) {
        Map<List<Integer>, Integer> diffMap = new HashMap<>();
        Map<List<Integer>, String> wordMap = new HashMap<>();
        for (String word : words) {
            List<Integer> diff = new ArrayList<>();
            for (int i = 1; i < word.length(); i++) {
                diff.add(word.charAt(i) - word.charAt(i - 1));
            }
            diffMap.put(diff, diffMap.getOrDefault(diff, 0) + 1);
            wordMap.put(diff, word);
        }
        for (Map.Entry<List<Integer>, Integer> entry : diffMap.entrySet()) {
            if(entry.getValue() == 1){
                return wordMap.get(entry.getKey());
            }
        }
        return "";
    }
}
