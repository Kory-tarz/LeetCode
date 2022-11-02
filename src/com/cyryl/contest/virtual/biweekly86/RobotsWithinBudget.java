package com.cyryl.contest.virtual.biweekly86;

public class RobotsWithinBudget {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        SegTree segTree = new SegTree(chargeTimes);
        int left = 0;
        int right = 0;
        long costSum = 0;
        int maxRobots = 0;
        while (right < chargeTimes.length) {
            costSum += runningCosts[right];
            int max = segTree.query(left, right);
            int k = right - left + 1;
            long currentCost = max + k * costSum;
            if (currentCost <= budget) {
                maxRobots = Math.max(k, maxRobots);
            } else {
                while (left <= right && currentCost > budget) {
                    costSum -= runningCosts[left];
                    left++;
                    max = segTree.query(left, right);
                    k = right - left + 1;
                    currentCost = max + k * costSum;
                }
            }
            right++;
        }
        return maxRobots;
    }

    private class SegTree {
        private int[] tree;
        private int size;

        public SegTree(int[] data) {
            size = data.length;
            tree = new int[4 * size];
            build(data, 1, 0, size - 1);
        }

        private void build(int[] data, int idx, int left, int right) {
            if (left == right) {
                tree[idx] = data[left];
            } else {
                int mid = (left + right) / 2;
                build(data, idx * 2, left, mid);
                build(data, idx * 2 + 1, mid + 1, right);
                tree[idx] = Math.max(tree[idx * 2], tree[idx * 2 + 1]);
            }
        }

        public int query(int start, int end) {
            return query(1, 0, size - 1, start, end);
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
