package com.cyryl.neetcode150.graph;

import java.util.*;


public class ReconstructItineraryV2 {

    private static final int FROM = 0;
    private static final int DEST = 1;

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> flightMap = new HashMap<>();
        for (List<String> ticket : tickets) {
            flightMap.putIfAbsent(ticket.get(FROM), new PriorityQueue<>());
            flightMap.putIfAbsent(ticket.get(DEST), new PriorityQueue<>());

            flightMap.get(ticket.get(FROM)).add(ticket.get(DEST));
        }
        LinkedList<String> result = new LinkedList<>();
        travel(flightMap, "JFK", result);
        return result;
    }

    private void travel(Map<String, PriorityQueue<String>> flightMap, String current, LinkedList<String> result) {
        PriorityQueue<String> flights = flightMap.get(current);
        while (!flights.isEmpty()) {
            String destination = flights.poll();
                travel(flightMap, destination, result);
        }
        result.addFirst(current);
    }
}
