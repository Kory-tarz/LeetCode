package com.cyryl.medium;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class JumpGameIIITest {

    @Test
    public void exampleTest1(){
        int[] input = {4,2,3,0,3,1,2};
        Assert.assertEquals(true, JumpGameIII.canReach(input, 5));
    }

    @Test
    public void exampleTest2(){
        int[] input = {4,2,3,0,3,1,2};
        Assert.assertEquals(true, JumpGameIII.canReach(input, 0));
    }

    @Test
    public void exampleTest3(){
        int[] input = {3,0,2,1,2};
        Assert.assertEquals(false, JumpGameIII.canReach(input, 2));
    }

}