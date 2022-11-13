package com.cyryl.contest.biweekly91;

import java.util.*;

public class MostProfitablePath {
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        final int SRC = 0;
        final int DEST = 1;
        Map<Integer, List<Integer>> tree = new HashMap<>();
        for (int[] edge : edges) {
            tree.putIfAbsent(edge[SRC], new ArrayList<>());
            tree.putIfAbsent(edge[DEST], new ArrayList<>());
            tree.get(edge[SRC]).add(edge[DEST]);
            tree.get(edge[DEST]).add(edge[SRC]);
        }
        Map<Integer, Integer> bobVisits = new HashMap<>();
        bobTravel(tree, bobVisits, bob, 0);
        return aliceTravel(tree, bobVisits, 0, 0, 0, amount, new HashSet<>());
    }

    private int aliceTravel(Map<Integer, List<Integer>> tree, Map<Integer, Integer> bobVisits, int curr, int time, int income, int[] amount, Set<Integer> visited) {
        if (visited.contains(curr)) {
            return Integer.MIN_VALUE;
        }
        visited.add(curr);
        System.out.println((bobVisits.getOrDefault(curr, Integer.MAX_VALUE)));
        if (bobVisits.getOrDefault(curr, Integer.MAX_VALUE) > time) {
            income += amount[curr];
        } else if (bobVisits.getOrDefault(curr, Integer.MAX_VALUE) == time) {
            income += amount[curr] / 2;
        }
        System.out.println("CURR: " + curr + " income: " + income);
        if(curr != 0 && tree.get(curr).size() == 1){
            return income;
        }
        int maxIncome = Integer.MIN_VALUE;
        for (Integer dest : tree.get(curr)) {
            maxIncome = Math.max(maxIncome, aliceTravel(tree, bobVisits, dest, time + 1, income, amount, visited));
        }
        return maxIncome;
    }


    public boolean bobTravel(Map<Integer, List<Integer>> tree, Map<Integer, Integer> visited, int curr, int time) {
        if (visited.containsKey(curr)) {
            return false;
        }
        System.out.println("BOB: " + curr);
        visited.put(curr, time);
        if(curr == 0){
            return true;
        }
        for (Integer dest : tree.get(curr)) {
            if (bobTravel(tree, visited, dest, time + 1)) {
                return true;
            }
        }
        visited.put(curr, Integer.MAX_VALUE);
        return false;
    }
}
