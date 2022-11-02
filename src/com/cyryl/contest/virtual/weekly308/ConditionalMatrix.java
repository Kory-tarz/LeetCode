package com.cyryl.contest.virtual.weekly308;

import java.util.*;

public class ConditionalMatrix {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[] inDegRow = new int[k+1];
        int[] inDegCol = new int[k+1];

        Map<Integer, Set<Integer>> rowCond = setConditions(inDegRow, rowConditions);
        Map<Integer, Set<Integer>> colCond = setConditions(inDegCol, colConditions);

        Map<Integer, Integer> rowPositions = calculatePositions(rowCond, inDegRow);
        Map<Integer, Integer> colPositions = calculatePositions(colCond, inDegCol);
        if (rowPositions == null || colPositions == null){
            return new int[0][0];
        }
        int[][] result = new int[k][k];
        for (int i = 1; i <= k; i++) {
            result[rowPositions.get(i)][colPositions.get(i)] = i;
        }
        return result;
    }

    private Map<Integer, Integer> calculatePositions(Map<Integer, Set<Integer>> conditions, int[] inDeg) {
        Map<Integer, Integer> positions = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < inDeg.length; i++) {
            if (inDeg[i] == 0) {
                queue.offer(i);
            }
        }
        int currPos = 0;
        while (!queue.isEmpty()){
            int curr = queue.poll();
            positions.put(curr, currPos);
            currPos++;
            for (Integer child : conditions.get(curr)) {
                inDeg[child]--;
                if(inDeg[child] == 0){
                    queue.offer(child);
                }
            }
        }
        if(!validateCondition(inDeg)){
            return null;
        }
        return positions;
    }

    private boolean validateCondition(int[] inDeg){
        for (int i = 1; i < inDeg.length; i++) {
            if(inDeg[i] > 0){
                return false;
            }
        }
        return true;
    }

    private Map<Integer, Set<Integer>> setConditions(int[] inDeg, int[][] conditions) {
        final int SRC = 0;
        final int DEST = 1;
        Map<Integer, Set<Integer>> conditionMap = new HashMap<>();
        for (int i = 1; i < inDeg.length; i++) {
            conditionMap.put(i, new HashSet<>());
        }
        for (int[] condition : conditions) {
            Set<Integer> srcConditions = conditionMap.get(condition[SRC]);
            if(!srcConditions.contains(condition[DEST])) {
                srcConditions.add(condition[DEST]);
                inDeg[condition[DEST]]++;
            }
        }
        return conditionMap;
    }
}
