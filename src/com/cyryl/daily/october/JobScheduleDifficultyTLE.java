package com.cyryl.daily.october;

public class JobScheduleDifficultyTLE {
    public int minDifficulty(int[] jobDifficulty, int d) {
        if(jobDifficulty.length < d){
            return -1;
        }
        return helper(jobDifficulty, 0, d, -1);
    }

    public int helper(int[] jobs, int job, int day, int currMax){
        if(job >= jobs.length){
            return currMax;
        }
        int result;
        if(currMax == -1){
            // first job of the day we have to perform it
            currMax = jobs[job];
            result = helper(jobs, job + 1, day, currMax);
        } else if (jobs.length - job + 1 == day) {
            // we need to work every day
            result = currMax + helper(jobs, job, day - 1, -1); // again just do loop no need for recursive calls everywhere
        } else {
            // work one more job
            int tempMax = Math.max(currMax, jobs[job]);
            result = helper(jobs, job + 1, day, tempMax); // just do loop instead, so we can calculate result
            // or proceed to next day if it's not the last day
            if(day > 1) {
                result = Math.min(result, currMax + helper(jobs, job, day - 1, -1));
            }
        }
        return result;
    }
}
