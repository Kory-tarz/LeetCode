package com.cyryl.neetcode150.heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class StoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> weights = Arrays.stream(stones)
                .boxed()
                .collect(Collectors.toCollection(() -> new PriorityQueue<>(Collections.reverseOrder())));
        while (weights.size() > 1) {
            int bigStone = weights.poll();
            int smallStone = weights.poll();
            if (bigStone != smallStone) {
                weights.add(bigStone - smallStone);
            }
        }
        return weights.size() > 0 ? weights.peek() : 0;
    }
}
