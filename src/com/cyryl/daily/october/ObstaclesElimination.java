package com.cyryl.daily.october;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/
 */

public class ObstaclesElimination {
    public int shortestPath(int[][] grid, int k) {
        final int X = 0;
        final int Y = 1;
        final int K = 2;
        final int DESTROYED = 0;
        final int VISITED = 1;
        int[][][] pathData = new int[grid.length][grid[0].length][2];
        pathData[0][0][VISITED] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0});
        int len = 0;
        int inQueue = 1;
        int nextQueue = 0;
        while (!queue.isEmpty()) {
            if (inQueue == 0) {
                inQueue = nextQueue;
                nextQueue = 0;
                len++;
            }
            int[] curr = queue.poll();
            System.out.println(curr[X] + " " + curr[Y]);
            inQueue--;
            if (curr[X] < 0 || curr[X] >= grid.length || curr[Y] < 0 || curr[Y] >= grid[0].length) {
                continue;
            }
            if (grid[curr[X]][curr[Y]] == 1) {
                curr[K]++;
                if (curr[K] > k) {
                    continue;
                }
            }
            if (pathData[curr[X]][curr[Y]][VISITED] == 1 && pathData[curr[X]][curr[Y]][DESTROYED] <= curr[K]) {
                continue;
            }
            if (curr[X] == grid.length - 1 && curr[Y] == grid[0].length - 1) {
                return len;
            }
            pathData[curr[X]][curr[Y]][VISITED] = 1;
            pathData[curr[X]][curr[Y]][DESTROYED] = curr[K];
            queue.add(new int[]{curr[X] + 1, curr[Y], curr[K]});
            queue.add(new int[]{curr[X] - 1, curr[Y], curr[K]});
            queue.add(new int[]{curr[X], curr[Y] + 1, curr[K]});
            queue.add(new int[]{curr[X], curr[Y] - 1, curr[K]});
            nextQueue += 4;
        }
        return -1;
    }
}
