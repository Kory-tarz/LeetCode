package com.cyryl.hard;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class WordLadderTest {

    WordLadder wordLadder = new WordLadder();

    @Test
    public void exampleTest(){
        String begin = "hit";
        String end = "cog";
        String[] dicArr = {"hot", "dot", "dog", "lot", "log", "cog"};
        List<String> dictionary = new ArrayList<>(Arrays.asList(dicArr));

        Assert.assertEquals(5, wordLadder.ladderLength(begin, end, dictionary));
    }

    @Test
    public void noConnection(){
        String begin = "hot";
        String end = "dog";
        String[] dicArr = {"hot", "dog"};
        List<String> dictionary = new ArrayList<>(Arrays.asList(dicArr));

        Assert.assertEquals(0, wordLadder.ladderLength(begin, end, dictionary));
    }

}