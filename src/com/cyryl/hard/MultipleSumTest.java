package com.cyryl.hard;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MultipleSumTest {

    MultipleSum multipleSum = new MultipleSum();

    @Test
    public void exampleTest(){
        int[] target = {9,3,5};
        int[] target2 = {1,1,1,2};
        int[] target3 = {8,5};

        //Assert.assertEquals(true, multipleSum.isPossible(target));
        Assert.assertEquals(false, multipleSum.isPossible(target2));
        Assert.assertEquals(true, multipleSum.isPossible(target3));
    }

    @Test
    public void exampleTestWhy() {
        int[] target = {9, 1, 5};
        Assert.assertEquals(true, multipleSum.isPossible(target));
    }

}