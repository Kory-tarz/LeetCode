package com.cyryl.neetcode150.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPoints {

    private static final int X = 0;
    private static final int Y = 1;

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingDouble(a -> Math.sqrt(Math.pow(a[X], 2) + Math.pow(a[Y], 2))));
        pq.addAll(Arrays.asList(points));
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll();
        }
        return result;
    }

}
