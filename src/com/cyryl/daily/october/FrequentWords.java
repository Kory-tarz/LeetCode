package com.cyryl.daily.october;

import java.util.*;

/**
 * https://leetcode.com/problems/top-k-frequent-words/
 */

public class FrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freq = new HashMap<>();
        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }
        Map<Integer, List<String>> reversedFreq = new HashMap<>();
        int maxFreq = 0;
        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            reversedFreq.putIfAbsent(entry.getValue(), new ArrayList<>());
            reversedFreq.get(entry.getValue()).add(entry.getKey());
            maxFreq = Math.max(maxFreq, entry.getValue());
        }
        int currFreq = maxFreq;
        List<String> result = new ArrayList<>();
        while (k > 0) {
            if (reversedFreq.containsKey(currFreq)) {
                List<String> wordsAtFreq = reversedFreq.get(currFreq);
                Collections.sort(wordsAtFreq);
                if(wordsAtFreq.size() <= k){
                    result.addAll(wordsAtFreq);
                    k -= wordsAtFreq.size();
                } else {
                    for (int i = 0; i < k; i++) {
                        result.add(wordsAtFreq.get(i));
                    }
                    k = 0;
                }
            }
            currFreq--;
        }
        return result;
    }
}
