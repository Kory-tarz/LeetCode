package com.cyryl.hard;

import java.util.HashMap;
import java.util.Map;


public class EatOrange {
    Map<Integer, Integer> memory = new HashMap<>();

    public int minDays(int n) {

        if (n <= 2)
            return n;
        if(memory.containsKey(n))
            return memory.get(n);

        memory.put(n, 1 + Math.min(n%2 + minDays(n/2), n%3 + minDays(n/3)));

        return memory.get(n);
    }
}
