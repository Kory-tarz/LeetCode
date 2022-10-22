package com.cyryl.contest.virtual.weekly312;

import java.util.*;

public class NumberOfGoodPaths {

    private final static int IDX = 0;
    private final static int VAL = 1;

    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[VAL]));

        for (int i = 0; i < vals.length; i++) {
            graph.put(i, new ArrayList<>());
            queue.offer(new int[]{i, vals[i]});
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        UnionFind unionFind = new UnionFind(vals.length);
        int totalCount = vals.length;

        while (!queue.isEmpty()) {
            int currVal = queue.peek()[VAL];
            List<Integer> nodes = new ArrayList<>();
            while (!queue.isEmpty() && queue.peek()[VAL] == currVal) {
                nodes.add(queue.poll()[IDX]);
            }
            for (Integer src : nodes) {
                for (Integer dest : graph.get(src)) {
                    if(vals[dest] <= currVal) {
                        unionFind.union(src, dest);
                    }
                }
            }
            if (nodes.size() > 1) {
                Map<Integer, Integer> parents = new HashMap<>();
                for (Integer node : nodes) {
                    int parent = unionFind.getParent(node);
                    int count = parents.getOrDefault(parent, 0);
                    totalCount += count;
                    parents.put(parent, count + 1);
                }
            }
        }
        return totalCount;
    }

    private class UnionFind {
        int[] parent;
        int[] rank;

        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
        }

        public int getParent(int v) {
            if (parent[v] != v) {
                parent[v] = getParent(parent[v]);
            }
            return parent[v];
        }

        public void union(int v, int u) {
            int pu = getParent(u);
            int pv = getParent(v);

            if (rank[pv] > rank[pu]) {
                parent[pu] = pv;
            } else if (rank[pu] > rank[pv]) {
                parent[pv] = pu;
            } else {
                parent[pu] = pv;
                rank[pv]++;
            }
        }
    }
}
