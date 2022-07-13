package com.cyryl.hard;

import java.util.*;

public class CriticalConnections {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        Map<Integer, List<Integer>> graph = new HashMap<>();

        int src, dest;
        for(List<Integer> edge : connections){
            src = edge.get(0);
            dest = edge.get(1);

            graph.putIfAbsent(src, new ArrayList<>());
            graph.putIfAbsent(dest, new ArrayList<>());

            graph.get(src).add(dest);
            graph.get(dest).add(src);

        }
        return null;
    }

    private int[] trajan(Map<Integer, List<Integer>> graph, int n){

        boolean[] inStack = new boolean[n];
        boolean[] visited = new boolean[n];
        int[] low = new int[n];
        int[] disc = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        int id = 0;
        return null;
    }
}
