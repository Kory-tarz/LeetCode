package com.cyryl.medium;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LongestPalindromicSubstringTest {

    @Test
    public void simple(){
        Assert.assertEquals("bab",LongestPalindromicSubstring.longestPalindrome("babad"));
        Assert.assertEquals("bb",LongestPalindromicSubstring.longestPalindrome("cbbd"));
    }

    @Test
    public void longSameChar(){
        Assert.assertEquals("aaaaa",LongestPalindromicSubstring.longestPalindrome("baaaaad"));
        Assert.assertEquals("eeexeee",LongestPalindromicSubstring.longestPalindrome("feeexeeeg"));
    }

    @Test
    public void noLongPal(){
        Assert.assertEquals("c",LongestPalindromicSubstring.longestPalindrome("cbed"));
    }
}