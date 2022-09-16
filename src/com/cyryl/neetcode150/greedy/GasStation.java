package com.cyryl.neetcode150.greedy;

/**
 * https://leetcode.com/problems/gas-station/
 */

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int startingPos = 0;
        while (startingPos < gas.length) {
            int currPos = startingPos;
            int stations = 0;
            int currGas = 0;
            do {
                currGas = currGas + gas[currPos] - cost[currPos];
                stations++;
                currPos = nextIndex(gas, currPos);
            } while (currGas >= 0 && currPos != startingPos);
            if (currPos == startingPos){
                return startingPos;
            } else {
                startingPos += stations;
            }
        }
        return -1;
    }

    private int nextIndex(int[] arr, int curr) {
        return (curr + 1) % arr.length;
    }
}
