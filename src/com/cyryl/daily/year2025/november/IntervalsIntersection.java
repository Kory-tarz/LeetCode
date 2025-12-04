package com.cyryl.daily.year2025.november;

import java.util.*;

public class IntervalsIntersection {

    private static final int FIRST = 0;
    private static final int LAST = 1;
    private static final int VALUE = 0;
    private static final int INTERVAL = 1;
    private static final int PRIORITY = 2;

    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int[] intersectionsCount = new int[intervals.length];
        Set<Integer> currentIntersections = new HashSet<>();
        int count = 0;
        int latestValue = -1;
        for (int i = 0; i <= intervals.length; i++) {
            int start;
            if (i == intervals.length) {
                start = Integer.MAX_VALUE;
            } else {
                start = intervals[i][0];
                int end = intervals[i][1];
                queue.add(new int[]{end - 1, i, FIRST});
                queue.add(new int[]{end, i, LAST});
                if (latestValue == start) {
                    intersectionsCount[i]++;
                }
            }
            while (queue.peek() != null && queue.peek()[VALUE] <= start) {
                int[] data = queue.poll();
                if ((data[PRIORITY] == FIRST && intersectionsCount[data[INTERVAL]] == 0)
                        || (data[PRIORITY] == LAST && intersectionsCount[data[INTERVAL]] == 1)) {
                    currentIntersections.forEach(intersectionId -> intersectionsCount[intersectionId]++);
                    currentIntersections.removeIf(intersectionId -> intersectionsCount[intersectionId] >= 2);
                    if (data[VALUE] == start) {
                        intersectionsCount[i]++;
                    }
                    count++;
                    latestValue = data[VALUE];
                }
            }
            currentIntersections.add(i);
        }
        return count;
    }
}
