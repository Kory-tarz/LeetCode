package com.cyryl.daily.august;

import java.util.*;
import java.util.stream.Collectors;

public class ReorderedPower {

    private Set<List<Integer>> digits;

    public boolean reorderedPowerOf2(int n) {
        List<Integer> digitCount = countDigits(n);
        return (digits.contains(digitCount));
    }

    public ReorderedPower() {
        digits = new HashSet<>();
        setup();
    }

    public void setup() {
        for (int i = 1; i < (int) (1e9 + 7); i = i << 1) {
            digits.add(countDigits(i));
        }
    }

    private List<Integer> countDigits(int num) {
        List<Integer> count = Arrays.stream(new int[10]).boxed().collect(Collectors.toList());
        while (num > 0) {
            count.set(num % 10, count.get(num % 10) + 1);
            num /= 10;
        }
        return count;
    }
}
