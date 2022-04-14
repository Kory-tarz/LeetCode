package com.cyryl.medium;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class NetworkDelayTest {

    @Test
    public void example(){
        int[][] input = {{2,1,1}, {2,3,1}, {3,4,1}};
        Assert.assertEquals(2, NetworkDelay.networkDelayTime(input, 4, 2));
    }

    @Test
    public void testBetterRoad(){
        int[][] input = {{1,2,1}, {2,3,2}, {1,3,2}};
        Assert.assertEquals(2, NetworkDelay.networkDelayTime(input, 3, 1));
    }

    @Test
    public void testShouldFail(){
        int[][] input = {{1,2,1}};
        Assert.assertEquals(-1, NetworkDelay.networkDelayTime(input, 2, 2));
    }

    @Test
    public void bigTest(){
        int[][] input = {{1,2,3}, {1,4,2}, {2,4,3}, {1,3,1}, {3,5,4}, {4,6,3}};
        Assert.assertEquals(5, NetworkDelay.networkDelayTime(input, 6, 1));
    }
}