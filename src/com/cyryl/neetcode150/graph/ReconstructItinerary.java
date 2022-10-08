package com.cyryl.neetcode150.graph;

import java.util.*;

/**
 * https://leetcode.com/problems/reconstruct-itinerary/
 */

// I have to always pick first airport in lexical order
public class ReconstructItinerary {

    private static final int FROM = 0;
    private static final int DEST = 1;

    @SuppressWarnings("Duplicates")
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> flightMap = new HashMap<>();
        Map<String, Integer> inDegree = new HashMap<>();
        List<String> result = new ArrayList<>();
        for (List<String> ticket : tickets) {
            flightMap.putIfAbsent(ticket.get(FROM), new ArrayList<>());
            flightMap.putIfAbsent(ticket.get(DEST), new ArrayList<>());
            inDegree.putIfAbsent(ticket.get(DEST), 0);

            flightMap.get(ticket.get(FROM)).add(ticket.get(DEST));
            inDegree.put(ticket.get(DEST), inDegree.get(ticket.get(DEST)) + 1);
        }
        travel(flightMap, inDegree, "JFK", result);
        return result;
    }

    private void travel(Map<String, List<String>> flightMap, Map<String, Integer> inDegree, String current, List<String> result) {
        List<String> destinations = flightMap.get(current);
        result.add(current);
        if(destinations.size() == 0){
            return;
        }
        int destIdx = findBestDest(destinations, inDegree);
        String dest = destinations.get(destIdx);
        destinations.remove(destIdx);
        inDegree.put(dest, inDegree.get(dest) - 1);
        travel(flightMap, inDegree, dest, result);
    }

    private int findBestDest(List<String> destinations, Map<String, Integer> inDegree) {
        int priority = 0;
        String name = "ZZZ";
        int idx = 0;
        for (int i = 0; i < destinations.size(); i++) {
            String dest = destinations.get(i);
            int connections = inDegree.getOrDefault(dest, 0);
            if (connections > priority) {
                idx = i;
                priority = connections;
                name = dest;
            } else if (connections == priority && dest.compareTo(name) < 0) {
                idx = i;
                name = dest;
            }
        }
        return idx;
    }


    private class Airport implements Comparable<Airport> {
        String name;
        int connections;

        public Airport(String name, int connections) {
            this.name = name;
            this.connections = connections;
        }

        @Override
        public int compareTo(Airport other) {
            if (this.connections == other.connections) {
                return this.name.compareTo(other.name);
            } else {
                return Integer.compare(other.connections, this.connections); // reverse order
            }
        }
    }
}
