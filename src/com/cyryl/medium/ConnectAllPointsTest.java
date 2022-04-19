package com.cyryl.medium;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConnectAllPointsTest {

    ConnectAllPoints connectAllPoints = new ConnectAllPoints();

    @Test
    public void exampleTests(){

        int[][] points = {{0,0},{2,2},{3,10},{5,2},{7,0}};
        Assert.assertEquals(20, connectAllPoints.minCostConnectPoints(points));
        int[][] points2 = {{3,12}, {-2,5}, {-4,1}};
        Assert.assertEquals(18, connectAllPoints.minCostConnectPoints(points2));
    }

    @Test
    public void onePoint(){
        int[][] points = {{2,2}};
        Assert.assertEquals(0, connectAllPoints.minCostConnectPoints(points));
    }

}