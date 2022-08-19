package com.cyryl.neetcode150.binsearch;

/**
 * https://leetcode.com/problems/koko-eating-bananas/
 */

public class KokoBanana {
    public int minEatingSpeed(int[] piles, int h) {
        if (h < piles.length) {
            return -1;
        }
        int max = Integer.MIN_VALUE;
        for (int pile : piles) {
            max = Math.max(pile, max);
        }
        return binSearch(piles, 1, max, h);
    }

    private boolean isEnoughSpeed(int[] piles, double k, int h) {
        int totalTimePeriods = 0;
        for (int i = piles.length - 1; i >= 0; i--) {
            totalTimePeriods += Math.ceil(piles[i] / k);
            if (totalTimePeriods > h) {
                return false;
            }
        }
        return true;
    }

    private int binSearch(int[] piles, int low, int high, int h) {
        int mid;
        while (low < high) {
            mid = (low + high) / 2;

            if (isEnoughSpeed(piles, mid, h)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }


}
