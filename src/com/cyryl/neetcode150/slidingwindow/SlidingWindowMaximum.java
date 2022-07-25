package com.cyryl.neetcode150.slidingwindow;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> monoQueue = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];
        int resultIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!monoQueue.isEmpty() && monoQueue.peekFirst() < i - k + 1) {
                monoQueue.pollFirst();
            }
            while (!monoQueue.isEmpty() && nums[monoQueue.peekLast()] <= nums[i]) {
                monoQueue.pollLast();
            }
            monoQueue.offerLast(i);
            if(i >= k - 1) {
                result[resultIndex] = nums[monoQueue.peekFirst()];
                resultIndex++;
            }
        }
        return result;
    }
}
