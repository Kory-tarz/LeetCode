package com.cyryl.daily.october;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PlantingSeeds {

    //PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt((int[] a) -> a[PLANT_TIME] + a[GROW_TIME]).reversed());
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        final int PLANT_TIME = 0;
        final int GROW_TIME = 1;
        PriorityQueue<int[]> pq = IntStream
                .range(0, plantTime.length)
                .mapToObj(i -> new int[]{plantTime[i], growTime[i]})
                .collect(Collectors
                        .toCollection(() -> new PriorityQueue<>(Comparator.comparingInt((int[] a) -> a[GROW_TIME]).reversed())));
        int dayCount = 0;
        int longestGrowthTime = 0;
        while (!pq.isEmpty()) {
            int[] seed = pq.poll();
            dayCount += seed[PLANT_TIME];
            longestGrowthTime = Math.max(longestGrowthTime - seed[PLANT_TIME], 0);
            longestGrowthTime = Math.max(longestGrowthTime, seed[GROW_TIME]);
        }
        return dayCount + longestGrowthTime;
    }
}
