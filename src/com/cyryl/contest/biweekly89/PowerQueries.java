package com.cyryl.contest.biweekly89;

import java.util.ArrayList;
import java.util.List;

public class PowerQueries {

    private final static int MOD = (int) 1e9 + 7;

    public int[] productQueries(int n, int[][] queries) {
        List<Integer> powers = new ArrayList<>();
        int power = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                powers.add(1 << power);
            }
            power++;
            n = n >> 1;
        }
        System.out.println(powers);
        SegTree segTree = new SegTree(powers);
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++){
            result[i] = segTree.getProduct(queries[i][0], queries[i][1]);
        }
        return result;
    }

    public class SegTree {
        long[] tree;
        int size;

        public SegTree(List<Integer> arr) {
            tree = new long[4 * arr.size()];
            size = arr.size();
            build(arr, 1, 0, size - 1);
        }

        private void build(List<Integer> arr, int idx, int left, int right) {
            if (left == right) {
                tree[idx] = arr.get(left);
            } else {
                int mid = (left + right) / 2;
                build(arr, idx * 2, left, mid);
                build(arr, idx * 2 + 1, mid + 1, right);
                tree[idx] = (tree[idx * 2] * tree[idx * 2 + 1]) % MOD;
            }
        }

        public int getProduct(int prodFrom, int prodTo){
            System.out.println("RANGE: " + prodFrom + " ," + prodTo);
            return (int) query(1, 0, size - 1, prodFrom, prodTo);
        }

        private long query(int idx, int left, int right, int prodFrom, int prodTo) {
            if (prodFrom > prodTo) {
                return 1;
            }
            if (prodFrom == left && prodTo == right) {
                return (int) tree[idx];
            } else {
                int mid = (left + right) / 2;
                long result = (query(idx * 2, left, mid, prodFrom, Math.min(mid, prodTo)) *
                        query(idx * 2 + 1, mid + 1, right, Math.max(mid + 1, prodFrom), prodTo)) % MOD;
                System.out.println("LEFT: " + left + " RIGHT: " + right + " SUM: " + result);
                return result;
            }
        }
    }
}
