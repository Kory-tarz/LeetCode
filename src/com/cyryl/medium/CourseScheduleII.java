package com.cyryl.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CourseScheduleII {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>(numCourses);
        int[] inDegree = new int[numCourses];
        boolean[] visited = new boolean[numCourses];
        int[] path = new int[numCourses];
        int pathIndex = 0;

        for(int i=0; i<numCourses; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i< prerequisites.length; i++){
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            inDegree[prerequisites[i][0]]++;
        }

        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<inDegree.length; i++){
            if(inDegree[i] == 0)
                stack.push(i);
        }
        if(stack.isEmpty())
            return new int[0];

        int course;

        while(!stack.isEmpty()){
            course = stack.pop();

            if(visited[course])
                return new int[0];
            visited[course] = true;

            path[pathIndex] = course;
            pathIndex++;

            for(int child : graph.get(course)){
                inDegree[child]--;
                if(inDegree[child] == 0)
                    stack.push(child);
            }
        }
        if (pathIndex < numCourses)
            return new int[0];
        else
            return path;
    }
}
