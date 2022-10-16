package com.cyryl.contest.biweekly89;

import java.util.*;

public class CreateComponents {
    public int componentValue(int[] nums, int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> degree = new HashMap<>();

        for (int[] edge : edges) {
            graph.putIfAbsent(edge[0], new HashSet<>());
            graph.putIfAbsent(edge[1], new HashSet<>());
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
            degree.put(edge[0], degree.getOrDefault(edge[0], 0) + 1);
            degree.put(edge[1], degree.getOrDefault(edge[1], 0) + 1);
        }
        int sum = 0;
        int maxValue = 0;
        Queue<Integer> leaves = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            maxValue = Math.max(maxValue, nums[i]);
            if (degree.getOrDefault(i, 0) == 1) {
                leaves.add(i);
            }
        }
        for (int i = maxValue; i < sum; i++) {
            if (sum % i == 0) {
                if (calculate(graph, degree, leaves, nums, i)) {
                    return sum / i - 1;
                }
            }
        }
        return 0;
    }

    private boolean calculate(Map<Integer, Set<Integer>> graph, Map<Integer, Integer> degree, Queue<Integer> leaves, int[] values, int target) {
        Map<Integer, Set<Integer>> graphCopy = new HashMap<>();
        for (int key : graph.keySet()) {
            graphCopy.put(key, new HashSet<>(graph.get(key)));
        }
        Map<Integer, Integer> degreeCopy = new HashMap<>(degree);
        Queue<Integer> leavesCopy = new LinkedList<>(leaves);
        int[] valuesCopy = values.clone();
        return calculateWithCopies(graphCopy, degreeCopy, leavesCopy, valuesCopy, target);
    }

    private boolean calculateWithCopies(Map<Integer, Set<Integer>> graph, Map<Integer, Integer> degree, Queue<Integer> leaves, int[] values, int target) {
        while (!leaves.isEmpty()) {
            int curr = leaves.poll();
            if (degree.get(curr) == 0) {
                continue;
            }
            degree.put(curr, 0);
            System.out.println(graph.get(curr).size());
            int parent = graph.get(curr).iterator().next();
            if (values[curr] == target) {
                values[parent] += target;
                if(values[parent] > target){
                    return false;
                }
            }
            degree.put(parent, degree.get(parent) - 1);
            graph.get(parent).remove(curr);
            // last node
            if (degree.get(parent) == 0) {
                return values[parent] == target;
            } else if (degree.get(parent) == 1) {
                leaves.offer(parent);
            }

        }
        return false;
    }
}
