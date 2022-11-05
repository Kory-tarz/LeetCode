package com.cyryl.contest.virtual.weekly316;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MakeArraysSimilar {
    public long makeSimilar(int[] nums, int[] target) {
        Arrays.sort(nums);
        PriorityQueue<Integer> even = new PriorityQueue<>();
        PriorityQueue<Integer> odd = new PriorityQueue<>();
        long count = 0;
        for (int num : target) {
            if (num % 2 == 0) {
                even.offer(num);
            } else {
                odd.offer(num);
            }
        }
        for (int num : nums) {
            int targetNum;
            if (num % 2 == 0) {
                targetNum = even.poll();
            } else {
                targetNum = odd.poll();
            }
            if (num < targetNum) {
                count +=  (targetNum - num) / 2;
            }
        }
        return count;
    }
}
