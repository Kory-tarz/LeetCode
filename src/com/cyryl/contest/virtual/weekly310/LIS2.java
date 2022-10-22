package com.cyryl.contest.virtual.weekly310;

import java.util.HashMap;
import java.util.Map;

public class LIS2 {
    public int lengthOfLIS(int[] nums, int k) {
        SegTree segTree = new SegTree();
        for (int i = 0; i < nums.length; i++) {
            int max = segTree.query(nums[i] - k, nums[i] - 1);
            segTree.update(nums[i], 1 + max);
        }
        return segTree.tree[1];
    }

    private class SegTree {

        private int MAX_SIZE = 10_000 + 1;
        private int[] tree;

        public SegTree() {
            tree = new int[4 * MAX_SIZE];
        }

        public void update(int pos, int val) {
            update(1, 1, MAX_SIZE, pos, val);
        }

        private void update(int idx, int left, int right, int pos, int val) {
            if (left > pos || right < pos) {
                return;
            }
            if (left == pos && right == pos) {
                tree[idx] = Math.max(tree[idx], val);
            } else {
                int mid = (left + right) / 2;
                update(2 * idx, left, mid, pos, val);
                update(2 * idx + 1, mid + 1, right, pos, val);
                tree[idx] = Math.max(tree[2 * idx], tree[2 * idx + 1]);
            }
        }

        public int query(int start, int end) {
            return query(1, 1, MAX_SIZE, start, end);
        }

        private int query(int idx, int left, int right, int start, int end) {
            if (left > end || right < start) {
                return 0;
            }
            if (left >= start && right <= end) {
                return tree[idx];
            } else {
                int mid = (left + right) / 2;
                return Math.max(query(idx * 2, left, mid, start, end), query(idx * 2 + 1, mid + 1, right, start, end));
            }
        }
    }
}
