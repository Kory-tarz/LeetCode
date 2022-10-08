package com.cyryl.neetcode150.graph;

import java.util.Comparator;
import java.util.PriorityQueue;

public class RisingWater {

    private final static int TIME = 0;
    private final static int X = 1;
    private final static int Y = 2;

    private final static int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int swimInWater(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        int maxTime = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[TIME]));
        queue.add(new int[]{grid[0][0], 0, 0});
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            maxTime = Math.max(cell[TIME], maxTime);
            System.out.println(maxTime);
            if (cell[X] == grid.length - 1 && cell[Y] == grid[0].length - 1) {
                return maxTime;
            }
            visit(grid, visited, cell, queue);
        }
        return maxTime;
    }

    private void visit(int[][] grid, boolean[][] visited, int[] cell, PriorityQueue<int[]> queue) {
        for (int[] dir : DIRS) {
            addCell(cell[X] + dir[0], cell[Y] + dir[1], grid, visited, queue);
        }
    }

    private void addCell(int x, int y, int[][] grid, boolean[][] visited, PriorityQueue<int[]> queue) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || visited[x][y]) {
            return;
        }
        visited[x][y] = true;
        queue.add(new int[]{grid[x][y], x, y});
    }
}
