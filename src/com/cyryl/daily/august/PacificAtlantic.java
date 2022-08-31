package com.cyryl.daily.august;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/pacific-atlantic-water-flow/
 */

public class PacificAtlantic {

    private static final int NOT_VISITED = 0;
    private static final int OCEAN = 1;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int lengthX = heights.length;
        int lengthY = heights[0].length;
        int[][] statusNorth = new int[lengthX][lengthY];
        int[][] statusSouth = new int[lengthX][lengthY];


        for (int y = 0; y < lengthY; y++) {
            // north ocean
            if (statusNorth[0][y] == NOT_VISITED) {
                flow(heights, statusNorth, 0, y, heights[0][y]);
            }
            // south ocean
            if (statusSouth[lengthX - 1][y] == NOT_VISITED) {
                flow(heights, statusSouth, lengthX - 1, y, heights[lengthX - 1][y]);
            }
        }

        for (int x = 0; x < lengthX; x++) {
            // west ocean
            if (statusNorth[x][0] == NOT_VISITED) {
                flow(heights, statusNorth, x, 0, heights[x][0]);
            }
            // east ocean
            if (statusSouth[x][lengthY - 1] == NOT_VISITED){
                flow(heights, statusSouth, x, lengthY - 1, heights[x][lengthY - 1]);
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int x = 0; x < lengthX; x++) {
            for (int y = 0; y < lengthY; y++) {
                if(statusNorth[x][y] == OCEAN && statusSouth[x][y] == OCEAN){
                    result.add(List.of(x, y));
                }
            }
        }
        return result;
    }

    private void flow(int[][] heights, int[][] status, int x, int y, int level) {
        if (x < 0 || y < 0 || x >= heights.length || y >= heights[0].length || heights[x][y] < level || status[x][y] != NOT_VISITED) {
            return;
        }
        status[x][y] = OCEAN;
        flow(heights, status, x + 1, y, heights[x][y]);
        flow(heights, status, x - 1, y, heights[x][y]);
        flow(heights, status, x, y + 1, heights[x][y]);
        flow(heights, status, x, y - 1, heights[x][y]);
    }


}
