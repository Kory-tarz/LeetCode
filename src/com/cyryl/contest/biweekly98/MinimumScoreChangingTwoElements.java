package com.cyryl.contest.biweekly98;

public class MinimumScoreChangingTwoElements {
    public int minimizeSum(int[] nums) {
        int[] min = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
        int[] max = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
        for (int num : nums) {
            for (int i = 0; i < 3; i++) {
                if(num > max[i]) {
                    int temp = max[i];
                    max[i] = num;
                    if(i > 0) {
                        max[i-1] = temp;
                    }
                }
            }
            for (int i = 0; i < 3; i++) {
                if(num < min[i]) {
                    int temp = min[i];
                    min[i] = num;
                    if(i > 0) {
                        min[i-1] = temp;
                    }
                }
            }
        }
        return Math.min(max[0] - min[2], Math.min(max[1] - min[1], max[2] - min[0]));

    }
}
