package com.cyryl.contest.virtual.weekly310;

import java.util.Arrays;
import java.util.PriorityQueue;

public class DivideIntervals {
    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int count = 0;
        for (int[] interval : intervals) {
            int begin = interval[0];
            int end = interval[1];
            if(minHeap.isEmpty() || minHeap.peek() >= begin){
                count++;
            } else {
                minHeap.poll();
            }
            minHeap.offer(end);
        }
        return count;
    }
}
