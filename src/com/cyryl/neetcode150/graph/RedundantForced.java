package com.cyryl.neetcode150.graph;

import java.util.*;

public class RedundantForced {

    private final static int SRC = 0;
    private final static int DEST = 1;

    public int[] findRedundantConnection(int[][] edges) {
        int[] result = null;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int src = edges[i][SRC];
            int dest = edges[i][DEST];
            graph.putIfAbsent(src, new ArrayList<>());
            graph.putIfAbsent(dest, new ArrayList<>());
            if(dfs(graph, new HashSet<>(), src, dest)){
                result = edges[i];
            }
            graph.get(src).add(dest);
            graph.get(dest).add(src);
        }
        return result;
    }

    private boolean dfs(Map<Integer, List<Integer>> graph, Set<Integer> visited, int src, int dest) {
        if(visited.contains(src)){
            return false;
        }
        if(src == dest){
            return true;
        }
        visited.add(src);
        boolean found = false;
        for (int v : graph.get(src)){
            found = found || dfs(graph, visited, v, dest);
        }
        return found;
    }
}
