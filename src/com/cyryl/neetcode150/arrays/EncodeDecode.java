package com.cyryl.neetcode150.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.
 */



public class EncodeDecode {

    private static final char DELIM = '$';

    public static void main(String[] args) {
        List<String> list = List.of("lint","code","love","you");
        System.out.println(encode(list));

    }

    public static String encode(List<String> strs) {
        return strs.stream().map(s-> "" + s.length() + DELIM + s).collect(Collectors.joining(""));
    }


    public static List<String> decode(String str) {
        int currentIndex = 0;
        List<String> result = new ArrayList<>();

        while (currentIndex < str.length()){
            int nextDelim = str.indexOf(DELIM, currentIndex);
            int len = Integer.parseInt(str.substring(currentIndex, nextDelim));
            result.add(str.substring(nextDelim+1, nextDelim + len + 1));
            currentIndex = nextDelim + len + 1;
        }
        return result;
    }
}
