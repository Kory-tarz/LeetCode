package com.cyryl.contest.virtual.weekly318;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.function.BiFunction;

public class HireKWorkers {
    public long totalCost(int[] costs, int k, int candidates) {
        final int COST = 0;
        final int IDX = 1;
        Comparator<int[]> cmp = (a, b) -> a[COST] == b[COST] ? a[IDX] - b[IDX] : a[COST] - b[COST];
        PriorityQueue<int[]> leftWorkers = new PriorityQueue<>(cmp);
        PriorityQueue<int[]> rightWorkers = new PriorityQueue<>(cmp);
        int leftIdx = 0;
        int rightIdx = costs.length - 1;
        long totalCost = 0;
        while (k > 0) {
            while (leftWorkers.size() < candidates && leftIdx < rightIdx) {
                leftWorkers.offer(new int[]{costs[leftIdx], leftIdx});
                leftIdx++;
            }
            while (rightWorkers.size() < candidates && rightIdx >= leftIdx) {
                rightWorkers.offer(new int[]{costs[rightIdx], rightIdx});
                rightIdx--;
            }
            if (!leftWorkers.isEmpty() && (rightWorkers.isEmpty() || leftWorkers.peek()[COST] < rightWorkers.peek()[COST])) {
                totalCost += leftWorkers.poll()[COST];
            } else {
                totalCost += rightWorkers.poll()[COST];
            }
            System.out.println(totalCost);
            k--;
        }
        return totalCost;
    }
}
