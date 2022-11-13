package com.cyryl.daily.novemeber;

import java.util.ArrayDeque;

/**
 * https://leetcode.com/problems/online-stock-span/
 */

public class StockSpanner {

    private ArrayDeque<int[]> MonoStack;
    private final static int PRICE = 0;
    private final static int SMALLER = 1;

    public StockSpanner() {
        MonoStack = new ArrayDeque<>();
    }

    public int next(int price) {
        int countSmaller = 1;
        while (!MonoStack.isEmpty() && MonoStack.peekFirst()[PRICE] <= price) {
            int[] top = MonoStack.pop();
            countSmaller += top[SMALLER] + 1;
        }
        MonoStack.push(new int[]{price, countSmaller - 1});
        return countSmaller;
    }
}
