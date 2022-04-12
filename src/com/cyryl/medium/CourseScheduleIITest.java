package com.cyryl.medium;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CourseScheduleIITest {

    @Test
    public void exampleTest1(){
        int[][] input = {{1,0},{2,0},{3,1},{3,2}};
        int[] output1 = {0,1,2,3};
        int[] output2 = {0,2,1,3};

        //Assert.assertArrayEquals(output1, CourseScheduleII.findOrder(4,input));
        Assert.assertArrayEquals(output2, CourseScheduleII.findOrder(4,input));
    }

    @Test
    public void exampleTest2() {
        int[][] input = {{1, 0}};
        int[] output2 = {0, 1};
        Assert.assertArrayEquals(output2, CourseScheduleII.findOrder(2, input));
    }

    @Test
    public void emptyStack() {
        int[][] input = {{1, 0}, {0, 1}};
        int[] output2 = {};
        Assert.assertArrayEquals(output2, CourseScheduleII.findOrder(2, input));
    }

    @Test
    public void impossibleTest() {
        int[][] input = {{2, 0}, {2, 1}, {1, 2}};
        int[] output2 = {};
        Assert.assertArrayEquals(output2, CourseScheduleII.findOrder(3, input));
    }

    @Test
    public void loneGuy(){
        int[][] input = {{2, 0}};
        int[] output2 = {1, 0, 2};
        Assert.assertArrayEquals(output2, CourseScheduleII.findOrder(3, input));
    }
}