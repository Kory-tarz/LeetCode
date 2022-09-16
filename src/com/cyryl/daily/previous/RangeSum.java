package com.cyryl.daily.previous;

import java.util.Arrays;

public class RangeSum {
    class NumArray {

        private int[] segTree;
        private int idxRange;
        private int[] original;
        private final int ROOT = 1;

        public NumArray(int[] nums) {
            idxRange = nums.length;
            original = nums;
            segTree = new int[4 * idxRange];
            for (int i = 0; i < nums.length; i++) {
                setUp(i, nums[i]);
            }
        }

        private void setUp(int index, int val) {
            update(index + 1, val, 1, idxRange, ROOT);
        }

        public void update(int index, int val) {
            int originalValue = original[index];
            int newValue = val - originalValue;
            original[index] = val;
            update(index + 1, newValue, 1, idxRange, ROOT);
        }

        private void update(int index, int val, int left, int right, int node) {
            segTree[node] += val;
            if (left == right) {
                return;
            }
            int mid = (left + right) / 2;

            if (index > mid) {
                update(index, val, mid + 1, right, 2 * node + 1);
            } else {
                update(index, val, left, mid, 2 * node);
            }
        }

        public int sumRange(int left, int right) {
            return sumRange(1, idxRange, left + 1, right + 1, ROOT);
        }

        private int sumRange(int currLeft, int currRight, int targetLeft, int targetRight, int node) {
            if (currLeft == targetLeft && currRight == targetRight) {
                return segTree[node];
            }
            int mid = (currLeft + currRight) / 2;
            int sum = 0;
            if (targetLeft <= mid) {
                sum += sumRange(currLeft, mid, targetLeft, Math.min(mid, targetRight), 2 * node);
            }
            if (targetRight > mid) {
                sum += sumRange(mid + 1, currRight,  Math.max(mid + 1, targetLeft), targetRight, 2 * node + 1);
            }
            return sum;
        }
    }
}
