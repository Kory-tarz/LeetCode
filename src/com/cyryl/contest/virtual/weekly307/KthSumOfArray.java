package com.cyryl.contest.virtual.weekly307;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSumOfArray {
    public long kSum(int[] nums, int k) {
        SegTree segTree = new SegTree(nums.length);
        PriorityQueue<Long> pq = segTree.build(nums);
        long currSum = 0;
        while (!pq.isEmpty() && k > 0) {
            System.out.println(currSum);
            currSum = pq.poll();
            k--;
        }
        return currSum;
    }

    private class SegTree {
        private long[] tree;
        private int size;

        SegTree(int size) {
            this.size = size;
            tree = new long[4 * size];
        }

        public PriorityQueue<Long> build(int[] nums) {
            PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
            build(nums, 1, 0, size - 1, pq);
            return pq;
        }

        private void build(int[] nums, int idx, int left, int right, PriorityQueue<Long> pq) {
            if (left == right) {
                tree[idx] = nums[left];
            } else {
                int mid = (left + right) / 2;
                build(nums, 2 * idx, left, mid, pq);
                build(nums, 2 * idx + 1, mid + 1, right, pq);
                tree[idx] = tree[2 * idx] + tree[2 * idx + 1];
            }
            pq.offer(tree[idx]);
        }
    }
}
