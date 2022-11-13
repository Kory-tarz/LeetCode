package com.cyryl.daily.novemeber;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ReverseWordsInString {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        int left = 0;
        int right = words.length - 1;
        while (left < right) {
            String tmp = words[left];
            words[left] = words[right];
            words[right] = tmp;
            left++;
            right--;
        }
        return String.join(" ", words);
    }
}
