package com.cyryl.neetcode150.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CheapestFlight {

    private final static int FROM = 0;
    private final static int DEST = 1;
    private final static int PRICE = 2;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        City[] cities = new City[n];
        for (int i = 0; i < n; i++) {
            cities[i] = new City();
        }
        for (int[] flight : flights) {
            cities[flight[FROM]].roads.add(new Road(flight[DEST], flight[PRICE]));
        }

        Queue<TravelStatus> queue = new LinkedList<>();
        cities[src].minCost = 0;
        queue.offer(new TravelStatus(src, 0));
        for (int i = 0; i <= k; i++) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                TravelStatus status = queue.poll();
                for (Road road : cities[status.city].roads) {
                    int cost = road.cost + status.currentCost;
                    if(cities[road.dest].isBetterDeal(cost)){
                        cities[road.dest].minCost = cost;
                        queue.offer(new TravelStatus(road.dest, cost));
                    }
                }
            }
        }
        return cities[dst].minCost;
    }

    private class TravelStatus {
        int city;
        int currentCost;

        public TravelStatus(int city, int currentCost) {
            this.city = city;
            this.currentCost = currentCost;
        }
    }

    private class City {
        List<Road> roads;
        int minCost;

        public City() {
            roads = new ArrayList<>();
            minCost = -1;
        }

        public boolean isBetterDeal(int cost){
            if(minCost == - 1){
                return true;
            } else {
                return cost < minCost;
            }
        }
    }

    private class Road {
        int dest;
        int cost;

        public Road(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }
}
