package com.cyryl.hard;

import org.junit.Assert;
import org.junit.Test;

public class EnvelopesTest {

    @Test
    public void example(){
        Envelopes env = new Envelopes();
        int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};

        Assert.assertEquals(3, env.maxEnvelopes(envelopes));
    }

}