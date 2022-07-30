package com.cyryl.neetcode150.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class RectangleHistogram {

    private final int HEIGHT = 0;
    private final int IDX = 1;

    public int largestRectangleArea(int[] heights) {
        int max = heights[0];
        Deque<int[]> stack = new ArrayDeque<>();
        stack.offerFirst(new int[]{heights[0], 0});

        for (int i = 1; i < heights.length; i++) {
            int indexAtHeight = i;
            if (heights[i] < heights[i - 1]) {
                while (!stack.isEmpty() && stack.peekFirst()[HEIGHT] > heights[i]) {
                    int[] removed = stack.removeFirst();
                    int removedLen = i - removed[IDX];
                    max = Math.max(removedLen * removed[HEIGHT], max);
                    indexAtHeight = Math.min(indexAtHeight, removed[IDX]);
                }
            }
            stack.offerFirst(new int[]{heights[i], indexAtHeight});
        }

        while (!stack.isEmpty()) {
            int[] removed = stack.removeFirst();
            System.out.println(Arrays.toString(removed));
            int removedLen = heights.length - removed[IDX];
            max = Math.max(removedLen * removed[HEIGHT], max);
        }

        return max;
    }
}
