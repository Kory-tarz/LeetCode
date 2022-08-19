package com.cyryl.daily.august;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/reduce-array-size-to-the-half/
 */

public class ReduceArray {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> freqMap = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(num -> 1)));
        PriorityQueue<Integer> sortedFreq = new PriorityQueue<>(Collections.reverseOrder());
        freqMap.forEach((key, value) -> sortedFreq.offer(value));
        int half = arr.length / 2;
        int currSize = arr.length;
        int removedIntegers = 0;
        while (currSize > half){
            int freq = sortedFreq.poll();
            currSize -= freq;
            removedIntegers++;
        }
        return removedIntegers;
    }
}
