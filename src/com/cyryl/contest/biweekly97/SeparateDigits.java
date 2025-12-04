package com.cyryl.contest.biweekly97;

import java.util.*;
import java.util.stream.Collectors;

public class SeparateDigits {
    public int[] separateDigits(int[] nums) {
        List<Stack<Integer>> stacks = Arrays.stream(nums).mapToObj(num -> {
            Stack<Integer> stack = new Stack<>();
            while (num > 0) {
                stack.push(num % 10);
                num /= 10;
            }
            return stack;
        }).collect(Collectors.toList());
        List<Integer> result = new ArrayList<>();
        for (Stack<Integer> stack : stacks) {
            while (!stack.isEmpty()) {
                result.add(stack.pop());
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}
