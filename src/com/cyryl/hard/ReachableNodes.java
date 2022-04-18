package com.cyryl.hard;

import java.util.*;

public class ReachableNodes {
    public int reachableNodes(int[][] edges, int maxMoves, int n) {

        Graph graph = new Graph(n, edges.length);
        boolean[] visited = new boolean[n];

        for(int[] edge : edges)
            graph.addEdge(edge[0], edge[1], edge[2]);

        if(graph.getEdges(0) == null)
            return 1;

        PriorityQueue<MovesToNode> queue = new PriorityQueue<>(Collections.reverseOrder());

        MovesToNode movesToNode = new MovesToNode(maxMoves, 0);
        queue.offer(movesToNode);
        int curNode;
        int movesLeft;
        int destNode;

        while (!queue.isEmpty()){
            movesToNode = queue.poll();
            curNode = movesToNode.node;
            movesLeft = movesToNode.moves;

            if (visited[curNode] || movesLeft == 0) {
                visited[curNode] = true;
                continue;
            }
            visited[curNode] = true;

            for(Graph.Edge edge : graph.getEdges(curNode)){
                destNode = edge.getDestination(curNode);
                if (movesLeft <= edge.value)
                    edge.setTraversed(movesLeft);
                else if (!visited[destNode]){
                    edge.setTraversed(edge.value);
                    movesToNode = new MovesToNode(movesLeft - edge.value - 1, destNode);
                    queue.offer(movesToNode);
                }
            }
        }
        int visitedCount = 0;

        for(int i = 0; i < visited.length; i++){
            if(visited[i])
                visitedCount++;
        }
        for(Graph.Edge edge : graph.getAllEdges()) {
            visitedCount += edge.traversed;
        }

        return visitedCount;
    }

    private class MovesToNode implements Comparable<MovesToNode> {
        public int moves;
        public int node;

        public MovesToNode(int moves, int node){
            this.moves = moves;
            this.node = node;
        }

        @Override
        public int compareTo(MovesToNode other) {
            return Integer.compare(this.moves, other.moves);
        }
    }


    private class Graph{

        int vertices;
        List<Edge> edges;
        Map<Integer, List<Edge>> connections;

        private class Edge{
            int source;
            int destination;
            int value;
            int traversed;

            public Edge(int source, int destination, int value){
                this.source = source;
                this.destination = destination;
                this.value = value;
                traversed = 0;
            }

            public int getDestination(int from){
                return source == from ? destination : source;
            }

            public void setTraversed(int moves){
                traversed = Math.min(traversed + moves, value);
            }

            public boolean isTraversed(){
                return traversed == value;
            }
        }

        public Graph(int vertices, int edgeCount){
            this.vertices = vertices;
            edges = new ArrayList<>(edgeCount);
            connections = new HashMap<>(vertices);
        }

        public void addEdge(int src, int dest, int val){
            Edge newEdge = new Edge(src, dest, val);
            connections.putIfAbsent(src, new ArrayList<>());
            connections.putIfAbsent(dest, new ArrayList<>());
            connections.get(src).add(newEdge);
            connections.get(dest).add(newEdge);
            edges.add(newEdge);
        }

        public List<Edge> getEdges(int vertex){
            return connections.get(vertex);
        }

        public List<Edge> getAllEdges(){
            return edges;
        }
    }
}
