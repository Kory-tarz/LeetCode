package com.cyryl.contest.virtual.weekly308;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CollectGarbage {

    private final static int METAL = 0;
    private final static int PAPER = 1;
    private final static int GLASS = 2;

    public int garbageCollection(String[] garbage, int[] travel) {
        Map<Character, Integer> trucks = new HashMap<>();
        trucks.put('M', METAL);
        trucks.put('P', PAPER);
        trucks.put('G', GLASS);

        int[] travelSum = new int[travel.length + 1];
        int sum = 0;
        for (int i = 0; i < travel.length; i++) {
            sum += travel[i];
            travelSum[i + 1] = sum;
        }
        System.out.println(Arrays.toString(travelSum));
        int totalTime = 0;
        for (Map.Entry<Character, Integer> truckEntry : trucks.entrySet()) {
            int garbageCount = 0;
            int lastVisit = -1;
            for (int i = garbage.length - 1; i >= 0; i--) {
                if (lastVisit == -1 && garbage[i].contains(String.valueOf(truckEntry.getKey()))) {
                    lastVisit = i;
                }
                for (int j = 0; j < garbage[i].length(); j++) {
                    if (garbage[i].charAt(j) == truckEntry.getKey()) {
                        garbageCount++;
                    }
                }
            }
            int truck = garbageCount + (lastVisit != -1 ? travelSum[lastVisit] : 0);
            System.out.println("TRUCK " + truckEntry.getKey() + " " + truck + " LAST VISIT: " + lastVisit + " COUNT " + truck);
            totalTime += truck;
        }
        return totalTime;
    }
}
