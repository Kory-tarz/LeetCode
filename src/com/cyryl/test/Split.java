package com.cyryl.test;

import java.util.Arrays;

public class Split {
    public static void test() {
        String abc = "xyz efg";
        Arrays.stream(abc.split("")).forEach(a -> System.out.println(a));
    }
}
