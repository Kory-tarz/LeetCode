package com.cyryl.daily.december;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindPath {

    private final static int SRC = 0;
    private final static int DEST = 1;

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, ArrayList<Integer>> graph = IntStream.range(0, n).boxed().collect(Collectors.toMap(Function.identity(), (v) -> new ArrayList<>()));
        for (int[] edge : edges) {
            graph.get(edge[SRC]).add(edge[DEST]);
            graph.get(edge[DEST]).add(edge[SRC]);
        }
        Set<Integer> visited = new HashSet<>();
        dfs(graph, visited, source);
        return visited.contains(destination);
    }

    private void dfs(Map<Integer, ArrayList<Integer>> graph, Set<Integer> visited, int curr){
        if(visited.contains(curr)){
            return;
        }
        visited.add(curr);
        for (Integer neighbour : graph.get(curr)) {
            dfs(graph, visited, neighbour);
        }
    }
}
