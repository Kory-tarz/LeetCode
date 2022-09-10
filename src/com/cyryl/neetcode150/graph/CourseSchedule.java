package com.cyryl.neetcode150.graph;

import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] inDeg = new int[numCourses];
        for (int[] pre : prerequisites) {
            int src = pre[0];
            int dest = pre[1];
            graph.putIfAbsent(src, new ArrayList<>());
            graph.putIfAbsent(dest, new ArrayList<>());
            graph.get(src).add(dest);
            inDeg[dest]++;
        }
        Queue<Integer> queue= new LinkedList<>();
        for (int i = 0; i < inDeg.length; i++) {
            if(inDeg[i] == 0){
                queue.offer(i);
            }
        }
        int total = 0;
        while (!queue.isEmpty()){
            total++;
            int course = queue.poll();
            List<Integer> nextCourses = graph.get(course);
            if(nextCourses == null){
                continue;
            }
            for (int next : nextCourses) {
                inDeg[next]--;
                if(inDeg[next] == 0){
                    queue.offer(next);
                }
            }
        }
        return total == numCourses;
    }

}
