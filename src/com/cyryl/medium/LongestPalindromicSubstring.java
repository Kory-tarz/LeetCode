package com.cyryl.medium;

import java.awt.Point;

public class LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        int maxPalindromic = 0;
        int currentIndex = 0;
        int currentPalLen = 1;
        int nextIndex = 0;
        int leftIndex;
        Point maxPalPos = new Point();

        while (currentIndex < s.length()){
            leftIndex = currentIndex;
            while (isTheSameChar(currentIndex, currentPalLen, s)){
                currentPalLen++;
                nextIndex++;
            }
            while(isTheSameCharAround(leftIndex, leftIndex + currentPalLen, s)){
                leftIndex--;
                currentPalLen += 2;
            }
            if(maxPalindromic < currentPalLen) {
                maxPalindromic = currentPalLen;
                maxPalPos.x = leftIndex;
                maxPalPos.y = leftIndex + currentPalLen;
            }
            currentIndex += nextIndex + 1;
            nextIndex = 0;
            currentPalLen = 1;
        }
        return s.substring(maxPalPos.x, maxPalPos.y);
    }

    private static boolean isTheSameChar(int index, int length, String s){
        int nextIndex = index+length;
        if(nextIndex >= s.length())
            return false;
        return s.charAt(index) == s.charAt(nextIndex);
    }

    private static boolean isTheSameCharAround(int leftIndex, int rightIndex, String s){
        if(rightIndex >= s.length() || leftIndex-1 < 0)
            return false;
        return s.charAt(rightIndex) == s.charAt(leftIndex-1);
    }
}