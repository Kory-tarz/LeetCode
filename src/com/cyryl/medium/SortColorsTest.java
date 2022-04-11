package com.cyryl.medium;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SortColorsTest {

    @Test
    public void exampleTest(){
        int[] input = {2, 0, 2, 1, 1, 0};
        SortColors.sortColors(input);
        Assert.assertArrayEquals(new int[]{0,0,1,1,2,2}, input);
    }

    @Test
    public void exampleTest2(){
        int[] input = {2, 0, 1};
        SortColors.sortColors(input);
        Assert.assertArrayEquals(new int[]{0,1,2}, input);
    }

    @Test
    public void myTest(){
        int[] input = {2, 1, 0, 0, 1, 2, 1, 1};
        SortColors.sortColors(input);
        Assert.assertArrayEquals(new int[]{0,0,1,1,1,1,2,2}, input);
    }
}