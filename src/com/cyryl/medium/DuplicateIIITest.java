package com.cyryl.medium;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DuplicateIIITest {

    @Test
    public void leetTests(){
        Assert.assertEquals(true, DuplicateIII.containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0));
        Assert.assertEquals(true, DuplicateIII.containsNearbyAlmostDuplicate(new int[]{1, 0, 1, 1}, 1, 2));
    }

    @Test
    public void whyFail(){
        Assert.assertEquals(false, DuplicateIII.containsNearbyAlmostDuplicate(new int[]{1, 5, 9, 1, 5, 9}, 2, 3));
    }

    @Test
    public void anotherMistake(){
        Assert.assertEquals(true, DuplicateIII.containsNearbyAlmostDuplicate(new int[]{1, 2, 2, 3, 1}, 3, 0));
    }

    @Test
    public void maxInteger(){
        Assert.assertEquals(false, DuplicateIII.containsNearbyAlmostDuplicate(new int[]{-2147483648, 2147483647}, 1, 1));
    }

    @Test
    public void moreFail(){
        Assert.assertEquals(true, DuplicateIII.containsNearbyAlmostDuplicate(new int[]{1, 3, 6, 2}, 1, 2));
    }
}