package com.cyryl.neetcode150.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {

    private final Deque<Integer> stack;
    private final Deque<Integer> minStack;

    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }

    public void push(int val) {
        if(minStack.isEmpty() || val <= minStack.peekFirst()){
            minStack.offerFirst(val);
        }
        stack.offerFirst(val);
    }

    public void pop() {
        int val = stack.removeFirst();
        if(val == minStack.peekFirst()){
            minStack.removeFirst();
        }
    }

    public int top() {
        return stack.peekFirst();
    }

    public int getMin() {
        return minStack.peekFirst();
    }
}
