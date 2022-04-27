package com.cyryl.hard;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CountDigitOneTest {

    @Test
    public void exampleTest(){
        CountDigitOne countDigitOne = new CountDigitOne();
        Assert.assertEquals(195, countDigitOne.countDigitOne(445));
        Assert.assertEquals(14, countDigitOne.countDigitOne(35));
        Assert.assertEquals(4, countDigitOne.countDigitOne(11));
        Assert.assertEquals(2, countDigitOne.countDigitOne(10));
        Assert.assertEquals(0, countDigitOne.countDigitOne(0));
        Assert.assertEquals(6, countDigitOne.countDigitOne(13));
        Assert.assertEquals(12, countDigitOne.countDigitOne(20));
        Assert.assertEquals(23, countDigitOne.countDigitOne(101));
        Assert.assertEquals(1, countDigitOne.countDigitOne(1));
        Assert.assertEquals(21, countDigitOne.countDigitOne(100));
    }

    @Test
    public void failTest(){
        CountDigitOne countDigitOne = new CountDigitOne();
        Assert.assertEquals(767944060, countDigitOne.countDigitOne(824883294));
        Assert.assertEquals(900000001, countDigitOne.countDigitOne(1000000000));
    }
    //2147483647;
    //824883294

}