package com.cyryl.neetcode150.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class DailyTemperatures {

    private class TempIdx {
        int temp;
        int idx;

        public TempIdx(int temp, int idx) {
            this.temp = temp;
            this.idx = idx;
        }
    }

    public int[] dailyTemperatures(int[] temperatures) {
        Deque<TempIdx> stack = new ArrayDeque<>();
        int[] result = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && stack.peekFirst().temp < temperatures[i]) {
                TempIdx temp = stack.removeFirst();
                result[temp.idx] = i - temp.idx;
            }
            stack.addFirst(new TempIdx(temperatures[i], i));
        }
        return result;
    }
}
