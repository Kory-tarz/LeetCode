package com.cyryl.hard;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CriticalEdgesTest {

    CriticalEdges criticalEdges = new CriticalEdges();

    @Test
    public void exampleTest(){
        int[][] input = {{0,1,1},{1,2,1},{2,3,2},{0,3,2},{0,4,3},{3,4,3},{1,4,6}};
        int[][] input2 = {{0,1,1},{1,2,1},{2,3,1},{0,3,1}};

        List<List<Integer>> result = criticalEdges.findCriticalAndPseudoCriticalEdges(5, input);

        System.out.println(result);

        result = criticalEdges.findCriticalAndPseudoCriticalEdges(4, input2);

        System.out.println(result);

        //System.out.println("Trajan Critical from: " + edge.src + " low: " + low[edge.src] + " to node: " + edge.dest + " low: " + low[edge.dest]);
    }
}