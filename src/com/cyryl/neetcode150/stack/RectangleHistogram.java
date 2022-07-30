package com.cyryl.neetcode150.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class RectangleHistogram {

    private final int HEIGHT = 0;
    private final int IDX = 1;
    private final int AREA = 1;

    public int largestRectangleArea(int[] heights) {
        int[][] maxArea = new int[heights.length][2];
        maxArea[0][HEIGHT] = heights[0];
        maxArea[0][AREA] = heights[0];
        int max = maxArea[0][AREA];
        Deque<int[]> stack = new ArrayDeque<>();
        stack.offerFirst(new int[]{heights[0], 0});

        for (int i = 1; i < heights.length; i++) {

            int distance = -1;
            int prevIdx = -1;

            if (heights[i] >= heights[i - 1]) {
                prevIdx = i - 1;
                distance = 2;
            } else {
                while (!stack.isEmpty() && stack.peekFirst()[HEIGHT] > heights[i]) {
                    int[] removed = stack.removeFirst();
                    int removedLen = i - removed[IDX];
                    max = Math.max(removedLen * removed[HEIGHT], max);
                }
                if (stack.isEmpty()) {
                    maxArea[i][HEIGHT] = heights[i];
                    maxArea[i][AREA] = heights[i];
                } else {
                    int[] prev = stack.peekFirst();
                    distance = i - prev[IDX] + 1;
                    prevIdx = prev[IDX];
                }
            }
            if (distance != -1) {
                maxArea[i] = maxOf(
                        new int[]{heights[i], heights[i]},
                        new int[]{maxArea[prevIdx][HEIGHT], maxArea[prevIdx][AREA] + maxArea[prevIdx][HEIGHT]},
                        new int[]{heights[prevIdx], heights[prevIdx] * distance});
            }
            stack.offerFirst(new int[]{heights[i], i});
            max = Math.max(maxArea[i][AREA], max);
        }
        while (!stack.isEmpty()) {
            int[] removed = stack.removeFirst();
            int removedLen = (heights.length - 1) - removed[IDX];
            max = Math.max(removedLen * removed[HEIGHT], max);
        }

        return max;
    }

    int[] maxOf(int[]... values) {
        int[] max = new int[2];
        for (int[] value : values) {
            if (value[AREA] == max[AREA]) {
                if (value[HEIGHT] > max[HEIGHT]) {
                    max = value;
                }
            } else if (value[AREA] > max[AREA]) {
                max = value;
            }
        }
        return max;
    }
}
