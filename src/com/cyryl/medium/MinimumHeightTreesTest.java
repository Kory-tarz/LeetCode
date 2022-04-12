package com.cyryl.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MinimumHeightTreesTest {
    @Test
    public void exampleTest1() {
        int[][] input = {{1, 0}, {1, 2}, {1, 3}};
        List<Integer> output = new ArrayList<>();
        output.add(1);

        //Assert.assertArrayEquals(output1, CourseScheduleII.findOrder(4,input));
        Assert.assertEquals(output, MinimumHeightTrees.findMinHeightTrees(4, input));
    }

    @Test
    public void exampleTest2() {
        int[][] input = {{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}};
        List<Integer> output = new ArrayList<>();
        output.add(3);
        output.add(4);

        //Assert.assertArrayEquals(output1, CourseScheduleII.findOrder(4,input));
        Assert.assertEquals(output, MinimumHeightTrees.findMinHeightTrees(6, input));
    }

    @Test
    public void twoNodes() {
        int[][] input = {{0, 1}};
        List<Integer> output = new ArrayList<>();
        output.add(0);
        output.add(1);
        Assert.assertEquals(output, MinimumHeightTrees.findMinHeightTrees(2, input));

    }

    @Test
    public void oneNodes() {
        int[][] input = {};
        List<Integer> output = new ArrayList<>();
        output.add(0);
        Assert.assertEquals(output, MinimumHeightTrees.findMinHeightTrees(1, input));
    }

    @Test
    public void myTest(){
        int[][] input = {{10, 9}, {9,1}, {1,3}, {3,4}, {4,5}, {5,7}, {4,6}, {6,8}, {8,11}, {11,0}};
        List<Integer> output = new ArrayList<>();
        output.add(4);
        Assert.assertEquals(output, MinimumHeightTrees.findMinHeightTrees(12, input));
    }

    @Test
    public void failedTest(){
        int[][] input = {{0, 1}, {1,2}, {1,3}, {2,4}, {3,5}, {4,6}};
        List<Integer> output = new ArrayList<>();
        output.add(1);
        output.add(2);
        Assert.assertEquals(output, MinimumHeightTrees.findMinHeightTrees(7, input));
    }
}
//System.out.println("MAX [" + i + "]= " + maxBranch[i]);