package com.cyryl.neetcode150.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/reconstruct-itinerary/
 */

public class ReconstructItinerary {

    private static final int FROM = 0;
    private static final int DEST = 1;

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> flightMap = new HashMap<>();
        for (List<String> ticket : tickets) {
            flightMap.putIfAbsent(ticket.get(FROM), new ArrayList<>());
            flightMap.putIfAbsent(ticket.get(DEST), new ArrayList<>());
            flightMap.get(ticket.get(FROM)).add(ticket.get(DEST));
        }
        return null;
    }
}
