package com.cyryl.neetcode150.greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class HandOfStraights {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length < groupSize){
            return false;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int card : hand) {
            queue.offer(card);
        }
        List<Integer> repeats = new ArrayList<>();
        int lastInHand = -1;
        int currGroupSize = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (lastInHand == -1 || lastInHand == curr + 1) {
                lastInHand = curr;
                currGroupSize++;
            } else if(lastInHand == curr) {
                repeats.add(curr);
            } else {
                System.out.println(curr);
                return false;
            }
            if(currGroupSize == groupSize){
                currGroupSize = 0;
                lastInHand = -1;
                queue.addAll(repeats);
                repeats = new ArrayList<>();
            }
        }
        return currGroupSize == 0;
    }
}
