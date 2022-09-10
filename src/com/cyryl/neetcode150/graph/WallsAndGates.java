package com.cyryl.neetcode150.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.lintcode.com/problem/663/
 */

public class WallsAndGates {

    private final static int WALL = -1;
    private final static int GATE = 0;
    private final static int EMPTY = Integer.MAX_VALUE;
    private final static int X = 0;
    private final static int Y = 1;

    private final static int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> queue = new LinkedList<>();

        for (int x = 0; x < rooms.length; x++) {
            for (int y = 0; y < rooms[x].length; y++) {
                if (rooms[x][y] == GATE) {
                    queue.offer(new int[]{x, y});
                }
            }
        }
        int elements = queue.size();
        int distance = 1;
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] dir : DIRS) {
                int[] next = new int[]{cell[X] + dir[X], cell[Y] + dir[Y]};
                if(next[X] < 0 || next[X] >= rooms.length || next[Y] < 0 || next[Y] >= rooms[0].length
                         || rooms[next[X]][next[Y]] != EMPTY){
                    continue;
                }
                rooms[next[X]][next[Y]] = distance;
                queue.offer(next);
            }
            elements--;
            if (elements == 0) {
                distance++;
                elements = queue.size();
            }
        }
    }
}
