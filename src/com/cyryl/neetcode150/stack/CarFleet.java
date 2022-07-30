package com.cyryl.neetcode150.stack;

import java.util.*;

/**
 * https://leetcode.com/problems/car-fleet/
 */

public class CarFleet {

    private class PosSpeed {
        int position;
        int speed;

        public PosSpeed(int position, int speed) {
            this.position = position;
            this.speed = speed;
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {
        PosSpeed[] posSpeeds = new PosSpeed[position.length];

        for (int i = 0; i < position.length; i++) {
            posSpeeds[i] = new PosSpeed(position[i], speed[i]);
        }
        Arrays.sort(posSpeeds, Comparator.comparingInt((PosSpeed a) -> a.position).reversed());
        double max = -1;
        int fleets = 0;

        for (int i = 0; i < posSpeeds.length; i++) {
            double arrival = (target - posSpeeds[i].position)/(double)posSpeeds[i].speed;
            if(max < arrival){
                fleets++;
                max = arrival;
            }
        }
        return fleets;
    }
}
