package com.cyryl.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/maximum-length-of-pair-chain/
 */

public class MaximumLengthOfPairChain {
    public int findLongestChain(int[][] pairs) {
        final int RIGHT = 1;
        final int LEFT = 0;
        PriorityQueue<int[]> pairsHeap = Arrays.stream(pairs)
                .collect(Collectors.
                        toCollection(() -> new PriorityQueue<>(Comparator.comparingInt(a -> a[RIGHT]))));
        int lastEnd = Integer.MIN_VALUE;
        int count = 1;
        while (!pairsHeap.isEmpty()) {
            int[] curr = pairsHeap.poll();
            if (curr[LEFT] > lastEnd) {
                lastEnd = curr[RIGHT];
                count++;
            }
        }
        return count;
    }
}
