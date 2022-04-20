package com.cyryl.hard;

import java.util.*;

public class CriticalEdges {

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {

        if(edges.length == 0)
            return null;

        List<Integer> criticalEdges = new ArrayList<>();
        List<Integer> pseudoEdges = new ArrayList<>();
        PriorityQueue<Edge> queue = new PriorityQueue<>(edges.length);
        Vertex[] vertices = new Vertex[n];

        for(int i=0; i<vertices.length; i++)
            vertices[i] = new Vertex(i);

        for(int i = 0; i<edges.length; i++){
            int[] edge = edges[i];
            queue.add(new Edge(edge[0], edge[1], edge[2], i));
        }

        int numberOfEdges = 0;
        int curWeight = queue.peek().weight;
        Edge curEdge;
        List<Edge> sameWeightEdges = new ArrayList<>();
        UnionFind unionFind = new UnionFind(n);

        while (numberOfEdges < n-1) {

            if (!queue.isEmpty() && queue.peek().weight == curWeight) {

                curEdge = queue.poll();

                int repDest = unionFind.find(curEdge.dest);
                int repSrc = unionFind.find(curEdge.src);

                if(repSrc != repDest)
                    sameWeightEdges.add(curEdge);

            } else {

                for (Edge edge : sameWeightEdges)
                    addEdge(edge, vertices);

                Trajan trajan = new Trajan(n);
                trajan.solve(vertices);
                trajan.setPseudoAndCritEdges(sameWeightEdges, pseudoEdges, criticalEdges);

                for(Edge edge : sameWeightEdges)
                    removeEdge(edge, vertices);

                for(Edge edge : sameWeightEdges){
                    int repDest = unionFind.find(edge.dest);
                    int repSrc = unionFind.find(edge.src);
                    if (repSrc != repDest) {
                        unionFind.union(edge.dest, edge.src);
                        addEdge(edge, vertices);
                        numberOfEdges++;
                    }
                }

                if(!queue.isEmpty()) {
                    sameWeightEdges = new ArrayList<>();
                    curWeight = queue.peek().weight;
                }
            }
        }

        List<List<Integer>> result = new ArrayList<>(2);
        result.add(criticalEdges);
        result.add(pseudoEdges);


        return result;
    }

    private class Trajan{

        private boolean[] inStack;
        private int[] low;
        private int[] ids;
        private Deque<Integer> stack;
        private final int NOT_VISITED = -1;
        int id;

        public Trajan(int n){
            inStack = new boolean[n];
            low = new int[n];
            ids = new int[n];
            Arrays.fill(ids, NOT_VISITED);
            stack = new ArrayDeque<>();
            id = 0;
        }

        public void solve(Vertex[] graph){

            for(int i=0; i< graph.length; i++)
                if(ids[i] == NOT_VISITED && graph[i].included) {
                    dfs(i, -1, graph);
                }
        }

        private void dfs(int curVertex, int from, Vertex[] graph){
            stack.push(curVertex);
            inStack[curVertex] = true;
            ids[curVertex] = low[curVertex] = id;
            id++;

            for(int dest : graph[curVertex].edges.keySet()){
                if(dest != from) {
                    if (ids[dest] == NOT_VISITED)
                        dfs(dest, curVertex, graph);
                    if (inStack[dest])
                        low[curVertex] = Math.min(low[curVertex], low[dest]);
                }
            }

            if(ids[curVertex] == low[curVertex]) {
                for(int node = stack.pop(); ; node=stack.pop()) {
                    inStack[node] = false;
                    low[node] = ids[curVertex];
                    if(node == curVertex)
                        break;
                }
            }
        }

        private void setPseudoAndCritEdges(List<Edge> edges, List<Integer> pseudo, List<Integer> critical){
            for(Edge edge : edges){
                if(low[edge.dest] == low[edge.src]) {
                    edge.critical = Edge.PSEUDO;
                    pseudo.add(edge.index);
                }
                else {
                    edge.critical = Edge.CRITICAL;
                    critical.add(edge.index);
                }
            }
        }

    }

    private void removeEdge(Edge edge, Vertex[] graph){
        graph[edge.dest].edges.remove(edge.src);
        graph[edge.src].edges.remove(edge.dest);
    }

    private void addEdge(Edge edge, Vertex[] graph){
        graph[edge.dest].edges.put(edge.src, edge);
        graph[edge.dest].included = true;
        graph[edge.src].edges.put(edge.dest, edge);
        graph[edge.src].included = true;
    }

    private class Vertex{
        int index;
        Map<Integer, Edge> edges;
        boolean included;

        public Vertex(int index){
            this.index = index;
            edges = new HashMap<>();
            included = false;
        }
    }

    private class UnionFind{

        int[] parent;
        int[] rank;

        public UnionFind(int n){
            parent = new int[n];
            rank = new int[n];

            for(int i=0; i<parent.length;i++)
                parent[i] = i;
        }

        public void union(int v, int otherV){
            int vParent = find(v);
            int otherParent = find(otherV);

            if(rank[vParent] > rank[otherParent])
                parent[otherParent] = vParent;
            else if (rank[otherParent] > rank[vParent])
                parent[vParent] = otherParent;
            else {
                parent[otherParent] = vParent;
                rank[vParent]++;
            }
        }

        public int find(int v){
            if (parent[v] != v)
                return find(parent[v]);
            return v;
        }
    }


    private class Edge implements Comparable<Edge>{
        int src;
        int dest;
        int critical;
        int weight;
        int index;
        final static int CRITICAL = 1;
        final static int PSEUDO = 0;
        final static int NOT_USED = -1;

        public Edge(int src, int dest, int weight, int index){
            this.src = src;
            this.dest = dest;
            this.weight = weight;
            this.index = index;
            critical = NOT_USED;

        }

        public void setCritical(){
            critical = CRITICAL;
        }

        public void setNotUsed(){
            critical = NOT_USED;
        }

        public int getDest(int from){
            return from == src ? dest : src;
        }

        @Override
        public int compareTo(Edge otherEdge){
            return Integer.compare(this.weight, otherEdge.weight);
        }

    }
}
