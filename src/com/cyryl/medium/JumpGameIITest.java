package com.cyryl.medium;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class JumpGameIITest {

    @Test
    public void exampleTest(){
        Assert.assertEquals(2, JumpGameII.jump(new int[]{2,3,1,1,4}));
    }

    @Test
    public void myDrawnTest(){
        Assert.assertEquals(7, JumpGameII.jump(new int[]{2,3,1,1,4, 2, 3, 2, 1, 1, 2, 2, 2, 8}));
    }

    @Test
    public void zeroJumps(){
        Assert.assertEquals(3, JumpGameII.jump(new int[]{3,3,0,0,3,0,0,9}));
    }

    @Test
    public void wrongAnswer(){
        Assert.assertEquals(2, JumpGameII.jump(new int[]{7,0,9,6,9,6,1,7,9,0,1,2,9,0,3}));
    }
}