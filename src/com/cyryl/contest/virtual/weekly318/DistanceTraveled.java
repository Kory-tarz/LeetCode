package com.cyryl.contest.virtual.weekly318;

import java.util.*;

public class DistanceTraveled {
    public long minimumTotalDistance(List<Integer> robots, int[][] factory) {
        final int IDX = 0;
        final int LIMIT = 1;
        final int VALUE = 1;
        TreeMap<Integer, Integer> factories = new TreeMap<>();
        for (int[] fac : factory) {
            factories.put(fac[IDX], fac[LIMIT]);
        }
        PriorityQueue<long[]> compensations = new PriorityQueue<>(Comparator.comparingLong((long[] a) -> a[IDX]).reversed());
        Collections.sort(robots);

        long totalDistance = 0;
        for (Integer robot : robots) {
            Integer leftFactory = factories.floorKey(robot);
            Integer rightFactory = factories.ceilingKey(robot);
            long leftDistance = leftFactory == null ? Long.MAX_VALUE : robot - leftFactory;
            long rightDistance = rightFactory == null ? Long.MAX_VALUE : rightFactory - robot;

            System.out.println("L: " + leftDistance + " R: " + rightDistance);
            long[] cumulativeCompensation = new long[]{Integer.MIN_VALUE,0};
            if(leftFactory != null) {
                while (!compensations.isEmpty() && compensations.peek()[IDX] > leftFactory) {
                    long[] compensation = compensations.poll();
                    cumulativeCompensation[VALUE] += compensation[VALUE];
                    cumulativeCompensation[IDX] = Math.max(cumulativeCompensation[IDX], compensation[IDX]);
                }
                System.out.println(cumulativeCompensation[VALUE]);
                leftDistance -= 2L * cumulativeCompensation[VALUE];
            }
            if(leftDistance <= rightDistance){
                totalDistance += leftDistance;
                updateFactory(leftFactory, factories);
            } else {
                totalDistance += rightDistance;
                updateFactory(rightFactory, factories);
                if(cumulativeCompensation[IDX] != Integer.MIN_VALUE){
                    compensations.offer(cumulativeCompensation);
                }
                compensations.offer(new long[]{rightFactory, (int)rightDistance});
            }
            System.out.println(totalDistance);
        }
        return totalDistance;
    }

    private void updateFactory(Integer factory, TreeMap<Integer, Integer> factories) {
        int newLimit = factories.get(factory) - 1;
        if (newLimit <= 0) {
            factories.remove(factory);
        } else {
            factories.put(factory, newLimit);
        }
    }
}
