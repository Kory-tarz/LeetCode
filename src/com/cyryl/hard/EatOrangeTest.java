package com.cyryl.hard;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class EatOrangeTest {

    @Test
    public void simple(){
        EatOrange eatOrange = new EatOrange();
        Assert.assertEquals(5, eatOrange.minDays(16));
        Assert.assertEquals(10, eatOrange.minDays(673));
        Assert.assertEquals(12, eatOrange.minDays(429));
    }

}