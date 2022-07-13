package com.cyryl.hard;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BitFlipsTest {

    BitFlips bitFlips = new BitFlips();

    @Test
    public void example(){
        int[] nums = {0,0,0,1,0,1,1,0};
        int k = 3;

        Assert.assertEquals(3, bitFlips.minKBitFlips(nums, k));
    }

}