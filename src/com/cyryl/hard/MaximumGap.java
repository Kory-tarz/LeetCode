package com.cyryl.hard;

import java.util.Arrays;

public class MaximumGap {

    private final int USED = 0;
    private final int MAX = 1;
    private final int MIN = 2;
    private final int EMPTY = -1;

    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int max = 0;

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        int bucketSize = Math.max(1, (max - min + 1) / nums.length);
        int[][] buckets = new int[((max - min) / bucketSize) + 1][];
        for(int i=0; i<buckets.length; i++) {
            buckets[i] = new int[]{-1, 0, Integer.MAX_VALUE};
        }

        for (int num : nums) {
            int i = (num - min) / bucketSize;
            if (buckets[i][USED] == EMPTY) {
                buckets[i][USED] = USED;
            }
            buckets[i][MAX] = Math.max(num, buckets[i][MAX]);
            buckets[i][MIN] = Math.min(num, buckets[i][MIN]);
        }
        int maxGap = 0;
        int prevMax = min;
        for(int[] bucket : buckets ){
            if(bucket[USED] == EMPTY){
                continue;
            }
            maxGap = Math.max(maxGap, bucket[MIN] - prevMax);
            prevMax = bucket[MAX];
        }
        return maxGap;
    }
}
