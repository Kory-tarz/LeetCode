package com.cyryl.medium;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class NextPermutationTest {


    @Test
    public void simpleNextPermutation() {
        int[] input = {1, 2, 3};
        NextPermutation.nextPermutation(input);
        Assert.assertArrayEquals(new int[]{1,3,2}, input);
    }

    @Test
    public void simple2NextPermutation() {
        int[] input = {1, 1, 5};
        NextPermutation.nextPermutation(input);
        Assert.assertArrayEquals(new int[]{1,5,1}, input);
    }

    @Test
    public void reverseNextPermutation() {
        int[] input = {3, 2, 1};
        NextPermutation.nextPermutation(input);
        Assert.assertArrayEquals(new int[]{1,2,3}, input);
    }

    @Test
    public void itIsNextPerm(){
        int[] input = {1, 2, 7, 6, 5, 4};
        NextPermutation.nextPermutation(input);
        Assert.assertArrayEquals(new int[]{1, 4, 2, 5, 6, 7}, input);
    }

    @Test
    public void moreSwappingNextPerm(){
        int[] input = {1, 2, 7, 6, 5, 4, 1};
        NextPermutation.nextPermutation(input);
        Assert.assertArrayEquals(new int[]{1, 4, 1, 2, 5, 6, 7}, input);
    }

    @Test
    public void middleSwapPerm(){
        int[] input = {5, 4, 7, 5, 3, 2};
        NextPermutation.nextPermutation(input);
        Assert.assertArrayEquals(new int[]{5, 5, 2, 3, 4, 7}, input);
    }

    @Test
    public void someSwappingNextPerm(){
        int[] input = {1, 2, 7, 6, 5, 4, 1};
        NextPermutation.nextPermutation(input);
        Assert.assertArrayEquals(new int[]{1, 4, 1, 2, 5, 6, 7}, input);
    }

    @Test
    public void differentNextPerm(){
        int[] input = {1, 3, 2};
        NextPermutation.nextPermutation(input);
        for (int num: input)
            System.out.print(num + " ");
        Assert.assertArrayEquals(new int[]{2, 1, 3}, input);
    }

    @Test
    public void longReverseNextPerm(){
        int[] input = {5, 10, 9, 9, 9, 6, 4, 2};
        NextPermutation.nextPermutation(input);
        Assert.assertArrayEquals(new int[]{6, 2, 4, 5, 9, 9, 9, 10}, input);
    }

    @Test
    public void lastPerm2(){
        int[] input = {2, 3, 1};
        NextPermutation.nextPermutation(input);
        Assert.assertArrayEquals(new int[]{3, 1, 2}, input);
    }

    @Test
    public void noHigherElementsBehind(){
        int[] input = {4, 2, 0, 2, 3, 2, 0};
        NextPermutation.nextPermutation(input);
        Assert.assertArrayEquals(new int[]{4, 2, 0, 3, 0, 2, 2}, input);
    }

    @Test
    public void noLowerElementsBehind(){
        int[] input = {4, 2, 0, 2, 6, 5, 4};
        NextPermutation.nextPermutation(input);
        Assert.assertArrayEquals(new int[]{4, 2, 0, 4, 2, 5, 6}, input);
    }

    @Test
    public void fuckMe(){
        int[] input = {2, 3, 1, 3, 3};
        NextPermutation.nextPermutation(input);
        Assert.assertArrayEquals(new int[]{2, 3, 3, 1, 3}, input);
    }
}