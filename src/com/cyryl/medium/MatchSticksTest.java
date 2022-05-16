package com.cyryl.medium;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MatchSticksTest {

    MatchSticks matchSticks = new MatchSticks();

    @Test
    public void example(){
        int[] sticks = {5,5,5,5,4,4,4,4,3,3,3,3};

        Assert.assertTrue(matchSticks.makesquare(sticks));
    }
}