package com.cyryl.contest.biweekly90;

import java.util.ArrayDeque;

public class NextGreaterElement4 {
    public int[] secondGreaterElement(int[] nums) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        ArrayDeque<Integer> secondGreater = new ArrayDeque<>();
        int[] result = new int[nums.length];
        for (int i = nums.length; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peekFirst() < nums[i]) {
                secondGreater.push(stack.pop());
            }
            if (stack.isEmpty()) {
                // no single number that is greater than current
                result[i] = -1;
            } else {

            }
        }
        return null;
    }
}
