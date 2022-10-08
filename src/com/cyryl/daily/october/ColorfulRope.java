package com.cyryl.daily.october;

/**
 * https://leetcode.com/problems/minimum-time-to-make-rope-colorful/
 */

public class ColorfulRope {

    private final static char NONE = ' ';

    public int minCost(String colors, int[] neededTime) {
        int cost = 0;
        char prevColor = NONE;
        int prevCost = 0;
        for (int i = 0; i < colors.length(); i++) {
            if (prevColor != colors.charAt(i)) {
                prevColor = colors.charAt(i);
                prevCost = neededTime[i];
            } else {
                cost += Math.min(prevCost, neededTime[i]);
                prevCost = Math.max(prevCost, neededTime[i]);
            }
        }
        return cost;
    }
}
