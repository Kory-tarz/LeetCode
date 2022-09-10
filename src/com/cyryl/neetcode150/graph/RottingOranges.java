package com.cyryl.neetcode150.graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    private final static int EMPTY = 0;
    private final static int FRESH = 1;
    private final static int ROTTEN = 2;
    private final static int X = 0;
    private final static int Y = 1;

    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        boolean hasFresh = false;

        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                if (grid[x][y] == ROTTEN) {
                    queue.offer(new int[]{x, y});
                } else if (grid[x][y] == FRESH) {
                    hasFresh = true;
                }
            }
        }
        if (!hasFresh) {
            return 0;
        }
        int time = 0;
        Queue<int[]> nextQueue = new LinkedList<>();

        while (!queue.isEmpty()) {
            int[] rotten = queue.poll();
            rotNeighbors(grid, rotten, nextQueue);
            if (queue.isEmpty()) {
                if (!nextQueue.isEmpty()) {
                    time++;
                }
                queue = nextQueue;
                nextQueue = new LinkedList<>();
            }
        }
        hasFresh = false;
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                if(grid[x][y] == FRESH){
                    hasFresh = true;
                }
            }
        }
        return hasFresh ? -1 : time;
    }

    private void rotNeighbors(int[][] grid, int[] rotten, Queue<int[]> queue){
        rot(grid, rotten[X] + 1, rotten[Y], queue);
        rot(grid, rotten[X] - 1, rotten[Y], queue);
        rot(grid, rotten[X], rotten[Y] + 1, queue);
        rot(grid, rotten[X], rotten[Y] - 1, queue);
    }

    private void rot(int[][] grid, int x, int y, Queue<int[]> queue){
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[x].length || grid[x][y] != FRESH){
            return;
        }
        grid[x][y] = ROTTEN;
        queue.offer(new int[]{x, y});
    }
}
