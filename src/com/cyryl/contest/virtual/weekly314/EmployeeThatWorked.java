package com.cyryl.contest.virtual.weekly314;

public class EmployeeThatWorked {

    private final static int ID = 0;
    private final static int LEAVE_TIME = 1;

    public int hardestWorker(int n, int[][] logs) {
        int maxTime = Integer.MIN_VALUE;
        int maxTimeId = 0;
        int prevFinishTime = 0;

        for (int i = 0; i < logs.length; i++) {
            int taskTime = logs[i][LEAVE_TIME] - prevFinishTime;
            if(taskTime > maxTime){
                maxTime = taskTime;
                maxTimeId = logs[i][ID];
            } else if (taskTime == maxTime) {
                maxTimeId = Math.min(maxTimeId, logs[i][ID]);
            }
            prevFinishTime = logs[i][LEAVE_TIME];
        }

        return maxTimeId;
    }
}
