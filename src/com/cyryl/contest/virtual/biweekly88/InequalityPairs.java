package com.cyryl.contest.virtual.biweekly88;

public class InequalityPairs {
    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        int[] c = new int[nums1.length];
        int shift = 20_000; // to make sure all numbers are in range [0;40_000];
        for (int i = 0; i < nums1.length; i++) {
            c[i] = nums1[i] - nums2[i] + shift;
        }
        Tree segTree = new Tree();
        long count = 0;
        for (int i = 0; i < c.length; i++) {
            count += segTree.query(c[i] + diff);
            segTree.update(c[i]);
        }
        return count;

    }

    private class Tree {
        private final int maxVal = 40_000;

        private long[] data;

        Tree() {
            data = new long[4 * maxVal];
        }

        public void update(int val) {
            update(1, 0, maxVal, val);
        }

        private void update(int idx, int left, int right, int val) {
            if (left > val || right < val) {
                return;
            }
            if (left == right) {
                data[idx]++;
            } else {
                int mid = (left + right) / 2;
                update(idx * 2, left, mid, val);
                update(idx * 2 + 1, mid + 1, right, val);
                data[idx] = data[idx * 2] + data[idx * 2 + 1];
            }
        }

        public long query(int val) {
            return query(1, 0, maxVal, 0, val);
        }

        private long query(int idx, int left, int right, int start, int end) {
            if (left > end || right < start) {
                return 0;
            }
            if (start <= left && end >= right) { // if entire interval satisfies equation
                return data[idx];
            } else {
                int mid = (left + right) / 2;
                return query(idx * 2, left, mid, start, end) +
                        query(idx * 2 + 1, mid + 1, right, start, end);
            }
        }
    }
}
