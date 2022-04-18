package com.cyryl.hard;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReachableNodesTest {

    @Test
    public void exampleTests(){
        ReachableNodes reachableNodes = new ReachableNodes();

        int[][] input = {{0,1,10},{0,2,1},{1,2,2}};
        int maxMoves = 6;
        int n = 3;

        Assert.assertEquals(13, reachableNodes.reachableNodes(input, maxMoves, n));

    }

}