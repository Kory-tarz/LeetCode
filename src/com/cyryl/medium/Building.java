package com.cyryl.medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Building {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int difference;
        int i = 0;
        int minBrick;

        while(i < heights.length-1){
            difference = heights[i+1] - heights[i];
            if(difference <= 0){
                i++;
                continue;
            }
            if(ladders > 0){
                ladders--;
                queue.offer(difference);
            }else{
                minBrick = queue.peek();
                if(minBrick < difference){
                    queue.poll();
                    queue.offer(difference);
                    bricks -= minBrick;
                }else{
                    bricks -= difference;
                }
                if(bricks < 0){
                    return i;
                }
            }
            i++;
        }
        return heights.length-1;
    }
}
