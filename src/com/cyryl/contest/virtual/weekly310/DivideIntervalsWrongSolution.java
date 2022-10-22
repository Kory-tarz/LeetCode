package com.cyryl.contest.virtual.weekly310;

public class DivideIntervalsWrongSolution {
    public int minGroups(int[][] intervals) {
        SegTree segTree = new SegTree();
        for (int[] interval : intervals) {
            segTree.update(interval[0], interval[1]);
        }
        return segTree.tree[1];
    }

    private class SegTree {

        private int MAX_SIZE = (int)1e6 + 1;
        private int[] tree;

        public SegTree(){
            tree = new int[4 * MAX_SIZE];
        }

        public void update(int start, int end){
            update(1, 1, MAX_SIZE, start, end);
        }

        private void update(int idx, int left, int right, int start, int end){
            if(left > end || right < start){
                return;
            }
            if(left == start && right == end){
                tree[idx]++;
            } else {
                int mid = (left + right) / 2;
                update(2*idx, left, mid, start, Math.min(end, mid));
                update(2*idx + 1,  mid + 1, right, Math.max(start, mid + 1), end);
                tree[idx] = Math.max(tree[2*idx+1], tree[2*idx]);
            }
        }
    }
}
