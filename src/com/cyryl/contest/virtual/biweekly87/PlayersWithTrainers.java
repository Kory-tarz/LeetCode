package com.cyryl.contest.virtual.biweekly87;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class PlayersWithTrainers {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        PriorityQueue<Integer> playersQueue = Arrays.stream(players).boxed().collect(Collectors.toCollection(PriorityQueue::new));
        PriorityQueue<Integer> trainersQueue = Arrays.stream(trainers).boxed().collect(Collectors.toCollection(PriorityQueue::new));
        int matches = 0;

        while (!playersQueue.isEmpty() && !trainersQueue.isEmpty()){
            int currPlayer = playersQueue.poll();
            boolean trainerFound = false;
            while (!trainersQueue.isEmpty() && !trainerFound){
                int currTrainer = trainersQueue.poll();
                if(currTrainer >= currPlayer){
                    matches++;
                    trainerFound = true;
                }
            }
        }
        return matches;
    }
}
