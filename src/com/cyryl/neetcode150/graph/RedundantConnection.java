package com.cyryl.neetcode150.graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/redundant-connection/
 */

public class RedundantConnection {

    private static final int MAX_EDGES = 1001;
    private static final int SRC = 0;
    private static final int DEST = 1;

    public int[] findRedundantConnection(int[][] edges) {
        int[] result = null;
        UnionFind unionFind = new UnionFind(MAX_EDGES);
        for (int[] edge : edges){
            if(unionFind.isUnion(edge[SRC], edge[DEST])){
                result = edge;
            }
            unionFind.addEdge(edge[SRC], edge[DEST]);
        }
        return result;
    }

    class UnionFind {
        int[] parent;
        int[] rank;

        public UnionFind(int size) {
            rank = new int[size];
            parent = new int[size];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
        }

        public void addEdge(int a, int b) {
            int pa = getParent(a);
            int pb = getParent(b);

            if (rank[pa] > rank[pb]) {
                parent[pb] = pa;
            } else if (rank[pb] > rank[pa]) {
                parent[pa] = pb;
            } else {
                parent[pb] = pa;
                rank[pa]++;
            }
        }

        public boolean isUnion(int a, int b) {
            return getParent(a) == getParent(b);
        }

        public int getParent(int v) {
            if (parent[v] != v) {
                parent[v] = getParent(parent[v]);
            }
            return parent[v];
        }
    }
}
