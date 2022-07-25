package com.cyryl.neetcode150.arrays;

import java.util.*;

/**
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 *
 * other ideas:
 * - quickselect on reversed map
 * - bucket sort? I think it's similar idea
 */


public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numToFreqMap = new HashMap<>();
        for (Integer num : nums){
            numToFreqMap.putIfAbsent(num, 0);
            int freq = numToFreqMap.get(num);
            numToFreqMap.put(num, freq+1);
        }
        Map<Integer, List<Integer>> freqToNumberMap = new HashMap<>();
        int maxFreq = 0;
        for (Integer num: numToFreqMap.keySet()){
            int freq = numToFreqMap.get(num);
            freqToNumberMap.putIfAbsent(freq, new ArrayList<>());
            freqToNumberMap.get(freq).add(num);
            maxFreq = Math.max(maxFreq, freq);
        }
        int[] result = new int[k];
        int resultIndex = 0;
        int possibleFreq = maxFreq;

        while (resultIndex < k && possibleFreq >= 0){
            if(freqToNumberMap.containsKey(possibleFreq)){
                for (int num : freqToNumberMap.get(possibleFreq)){
                    result[resultIndex] = num;
                    resultIndex++;
                }
            }
            possibleFreq--;
        }
        return result;
    }
}
