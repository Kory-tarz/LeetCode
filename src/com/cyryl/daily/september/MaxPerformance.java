package com.cyryl.daily.september;

import java.util.*;

/**
 * https://leetcode.com/problems/maximum-performance-of-a-team/
 */

public class MaxPerformance {

    private final static int MOD = (int) 1e9 + 7;

    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        List<Engineer> engineers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            engineers.add(new Engineer(speed[i], efficiency[i]));
        }
        engineers.sort(Comparator.comparingInt((Engineer e) -> e.efficiency).reversed());

        long bestPerformance = 0;

        PriorityQueue<Engineer> picked = new PriorityQueue<>(Comparator.comparingInt(e->e.speed));
        long teamEff = Integer.MAX_VALUE;
        long sum = 0;
        for (int i = 0; i < k; i++) {
            picked.offer(engineers.get(i));
            sum += engineers.get(i).speed;
            teamEff = Math.min(teamEff, engineers.get(i).efficiency);
            bestPerformance = Math.max(bestPerformance, sum * teamEff);
        }
        for (int i = k; i <= n; i++) {
            long perf = sum * teamEff;
            bestPerformance = Math.max(perf, bestPerformance);
            sum -= picked.poll().speed;
            if (i < n) {
                teamEff = engineers.get(i).efficiency;
                sum += engineers.get(i).speed;
                picked.offer(engineers.get(i));
            }
        }
        return (int) (bestPerformance % MOD);
    }

    private class Engineer {
        int speed;
        int efficiency;

        public Engineer(int speed, int efficiency) {
            this.speed = speed;
            this.efficiency = efficiency;
        }

        @Override
        public String toString() {
            return "Speed: " + speed + " efficiency: " + efficiency;
        }
    }
}
