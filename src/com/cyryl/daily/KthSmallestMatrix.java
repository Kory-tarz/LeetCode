package com.cyryl.daily;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 */

// FAILED APPROACH

public class KthSmallestMatrix {

    private final int X = 0;
    private final int Y = 1;

    public int kthSmallest(int[][] matrix, int k) {
        if (matrix.length == 1) {
            return matrix[0][0];
        }
        int current = 0;
        int[] pos = {0, 0};
        int[] nextDown = {1, 0};
        int[] nextSide = {0, 1};

        while (current < k) {
            if (isOutOfBounds(matrix, nextSide) || matrix[nextDown[X]][nextDown[Y]] < matrix[nextSide[X]][nextSide[Y]]) {
                pos = nextDown;
                nextDown = getNextDown(matrix, nextDown, nextSide);
            } else {
                pos = nextSide;
                nextSide = getNextSide(matrix, nextSide, nextDown);
            }
            System.out.println(matrix[pos[X]][pos[Y]] + " " + Arrays.toString(pos));
            current++;
        }
        return matrix[pos[X]][pos[Y]];
    }

    private boolean isOutOfBounds(int[][] matrix, int[] pos) {
        if(pos[X] >= matrix.length || pos[Y] >= matrix[0].length){
            return true;
        }
        return false;
    }

    private int[] getNextDown(int[][] matrix, int[] pos, int[] other) {
        int x = pos[X] + 1;
        if (x >= matrix.length) {
            return new int[]{other[X] + 1, pos[Y] + 1};
        }
        return new int[]{x, pos[Y]};
    }

    private int[] getNextSide(int[][] matrix, int[] pos, int[] other) {
        int y = pos[Y] + 1;
        if (y >= matrix[pos[X]].length) {
            return new int[]{pos[X] + 1, other[Y] + 1};
        }
        return new int[]{pos[X], y};
    }
}
