package com.cyryl.daily.year2025.november;

import java.util.*;

public class TasksAndServers {
    public int[] assignTasks(int[] servers, int[] tasks) {
        PriorityQueue<int[]> serverQueue = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for (int i = 0; i < servers.length; i++) {
            serverQueue.add(new int[]{servers[i], i});
        }
        PriorityQueue<int[]> taskCompletionTime = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        Queue<Integer> incomingTasks = new ArrayDeque<>();
        int[] serverAssignment = new int[tasks.length];
        int currTaskTime = 0;
        int currTime = 0;
        while (currTaskTime < tasks.length || !taskCompletionTime.isEmpty()) {
            if (currTaskTime >= tasks.length) {
                currTime = taskCompletionTime.peek()[0];
            } else {
                currTime = currTaskTime;
                incomingTasks.add(currTaskTime);
                currTaskTime++;
            }
            while (!taskCompletionTime.isEmpty() && taskCompletionTime.peek()[0] <= currTime) {
                int releasedServer = taskCompletionTime.poll()[1];
                serverQueue.add(new int[]{servers[releasedServer], releasedServer});
            }
            while (!incomingTasks.isEmpty() && !serverQueue.isEmpty()) {
                int nextTask = incomingTasks.poll();
                int assignedServer = serverQueue.poll()[1];
                serverAssignment[nextTask] = assignedServer;
                taskCompletionTime.add(new int[]{currTime + tasks[nextTask], assignedServer});
            }
        }
        return serverAssignment;
    }
}
