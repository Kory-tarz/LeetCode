package com.cyryl.neetcode150.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.function.BiFunction;

public class PolishNotation {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        BiFunction<Integer, Integer, Integer> fun;

        for (String token : tokens) {
            fun = null;
            switch (token) {
                case "*" -> fun = (a, b) -> a * b;
                case "+" -> fun = (a, b) -> a + b;
                case "-" -> fun = (a, b) -> a - b;
                case "/" -> fun = (a, b) -> a / b;
                default -> stack.offerFirst(Integer.parseInt(token));
            }
            if (fun != null) {
                int second = stack.removeFirst();
                int first = stack.removeFirst();
                stack.offerFirst(fun.apply(first, second));
            }
        }
        return stack.removeFirst();
    }

}
