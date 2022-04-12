package com.cyryl.medium;

import java.util.ArrayList;
import java.util.List;

public class MinimumHeightTrees {

    static int[] maxBranch;
    static int longestPath;
    static int longestPathIndex;

    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {

        List<List<Integer>> graph = new ArrayList<>(n);
        List<Integer> roots = new ArrayList<>(2);
        maxBranch = new int[n];
        longestPath = 0;

        if(edges.length == 0) {
            roots.add(0);
            return roots;
        }

        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[1]).add(edge[0]);
            graph.get(edge[0]).add(edge[1]);
        }

        int nodeVal = 0;
        while (graph.get(nodeVal).size() != 1) {
            nodeVal++;
        }

        searchLongestPath(graph, nodeVal, -1, 0);
        searchLongestPath(graph, longestPathIndex, -1, 0);
        searchLongestPath(graph, longestPathIndex, -1, 0);

        int middlePoint;
        if(longestPath % 2 == 0)
             middlePoint = longestPath/2;
        else
            middlePoint = longestPath/2+1;

        for(int i=0; i<maxBranch.length; i++) {
            System.out.println("MAX [" + i + "]= " + maxBranch[i]);
            if(maxBranch[i] == middlePoint)
                roots.add(i);
        }
        return roots;
    }

    public static void searchLongestPath(List<List<Integer>> graph, int node, int from, int value){
        maxBranch[node] = Math.max(value, maxBranch[node]);
        if(value >= longestPath){
            longestPath = value;
            longestPathIndex = node;
        }
        for(int neighbour: graph.get(node)){
            if(neighbour != from)
                searchLongestPath(graph, neighbour, node, value+1);
        }
    }
}
