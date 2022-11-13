package com.cyryl.contest.biweekly91;

import java.util.*;
import java.util.stream.Collectors;

public class DistinctAverages {
    public int distinctAverages(int[] nums) {
        Set<Double> result = new HashSet<>();
        PriorityQueue<Integer> min = Arrays.stream(nums).boxed().collect(Collectors.toCollection(() -> new PriorityQueue<>()));
        PriorityQueue<Integer> max = Arrays.stream(nums).boxed().collect(Collectors.toCollection(() -> new PriorityQueue<>(Collections.reverseOrder())));
        for (int i = 1; i <= nums.length / 2; i++) {
            result.add((min.poll() + max.poll()) / 2.0);
        }
        return result.size();
    }
}
