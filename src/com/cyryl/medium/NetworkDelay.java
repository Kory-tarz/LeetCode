package com.cyryl.medium;

import java.util.*;

public class NetworkDelay {

    static final int FROM_NODE = 0;
    static final int TO_NODE = 1;
    static final int TRAVEL_TIME = 2;
    static final int MAX_TIME = 6001;

    public static int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>(n);
        int[] timeToReach = new int[n+1];
        Arrays.fill(timeToReach, MAX_TIME);
        int maxTime = 0;

        for(int i=1; i<=n; i++){
            graph.put(i, new HashMap<>());
        }

        for (int[] time : times) {
            graph.get(time[FROM_NODE]).put(time[TO_NODE], time[TRAVEL_TIME]);
        }

        PriorityQueue<TravelTime> queue = new PriorityQueue<>();
        queue.offer(new TravelTime(0, k));

        TravelTime node;
        Map<Integer, Integer> children;

        while(!queue.isEmpty()){
            node = queue.remove();

            if(timeToReach[node.node] > node.time) {

                timeToReach[node.node] = node.time;
                children = graph.get(node.node);

                for (Integer child : children.keySet()) {
                    if(timeToReach[child] > children.get(child) + node.time)
                        queue.offer(new TravelTime(children.get(child) + node.time, child));
                }
            }
        }
        for(int i=1; i<=n; i++){
            if(timeToReach[i] == MAX_TIME)
                return -1;
            maxTime = Math.max(maxTime, timeToReach[i]);
        }
        return maxTime;
    }

    private static class TravelTime implements Comparable<TravelTime> {
        public int time;
        public int node;

        public TravelTime(int time, int node){
            this.time = time;
            this.node = node;
        }

        @Override
        public int compareTo(TravelTime other) {
            return Integer.compare(this.time, other.time);
        }
    }
}
