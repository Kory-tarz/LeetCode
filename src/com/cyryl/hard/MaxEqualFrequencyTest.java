package com.cyryl.hard;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaxEqualFrequencyTest {

    MaxEqualFrequency maxEqualFrequency = new MaxEqualFrequency();

    @Test
    public void exampleTests(){
        int[] input = {2,2,1,1,5,3,3,5};
        int[] input2 = {1,1,1,2,2,2,3,3,3,4,4,4,5};

        //Assert.assertEquals(7, maxEqualFrequency.maxEqualFreq(input));
        Assert.assertEquals(13, maxEqualFrequency.maxEqualFreq(input2));
    }

    @Test
    public void allDiffTest(){
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Assert.assertEquals(input.length, maxEqualFrequency.maxEqualFreq(input));
    }

    @Test
    public void onlyTwoTheSame(){
        int[] input = {1, 2, 3, 4, 5, 6, 7, 1, 9};
        Assert.assertEquals(input.length, maxEqualFrequency.maxEqualFreq(input));
    }

    @Test
    public void oneMoreCase(){
        int[] input = {1,1,1,2,2,2};
        Assert.assertEquals(5, maxEqualFrequency.maxEqualFreq(input));
    }

    @Test
    public void everythingTheSame(){
        int[] input = {1,1,1,1,1,1};
        Assert.assertEquals(6, maxEqualFrequency.maxEqualFreq(input));
    }


}