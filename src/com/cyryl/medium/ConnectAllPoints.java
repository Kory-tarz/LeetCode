package com.cyryl.medium;

import java.util.PriorityQueue;

public class ConnectAllPoints {
    public int minCostConnectPoints(int[][] points) {

        boolean[] connectedPoints = new boolean[points.length];
        int[] minWeight = new int[points.length];
        int numberOfPoints = 0;
        int curPoint;
        int totalValue = 0;
        int weight;
        Edge curEdge;

        for(int i=0; i<points.length;i++)
            minWeight[i] = Integer.MAX_VALUE;

        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.offer(new Edge(0, 0));

        while(numberOfPoints < points.length){
            curEdge = queue.poll();
            if(connectedPoints[curEdge.dest])
                continue;
            curPoint = curEdge.dest;
            connectedPoints[curPoint] = true;
            numberOfPoints++;
            totalValue += curEdge.weight;

            for(int i=0; i<points.length; i++){
                if(!connectedPoints[i]){
                    weight = Math.abs(points[i][0] - points[curPoint][0]) + Math.abs(points[i][1] - points[curPoint][1]);
                    if (minWeight[i] > weight) {
                        minWeight[i] = weight;
                        queue.offer(new Edge(i, weight));
                    }
                }

            }

        }
        return totalValue;
    }

    private class Edge implements Comparable<Edge>{
        int dest;
        int weight;

        public Edge(int dest, int weight){
            this.weight = weight;
            this.dest = dest;
        }

        @Override
        public int compareTo(Edge otherEdge) {
            return Integer.compare(this.weight, otherEdge.weight);
        }
    }
}
