package com.cyryl.medium;

import java.util.LinkedList;

public class InterleavingString {

    private final char DUMMY = '!';

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        LinkedList<Character> commonElements = new LinkedList<>();
        int indexFirst = 0;
        int indexSecond = 0;
        int indexResult = 0;

        while (indexResult < s3.length()) {
            char firstChar = indexFirst < s1.length() ? s1.charAt(indexFirst) : DUMMY;
            char secondChar = indexSecond < s2.length() ? s2.charAt(indexSecond) : DUMMY;
            if ((firstChar == secondChar) && firstChar == s3.charAt(indexResult)) {
                commonElements.addLast(firstChar);
                indexFirst++;
                indexSecond++;
            } else if (firstChar == s3.charAt(indexResult)) {
                indexFirst++;
                    while(commonElements.size() > 0 && firstChar != commonElements.peekFirst()) {
                        indexSecond--;
                        commonElements.removeFirst();
                    }
                } else if (secondChar == s3.charAt(indexResult)) {
                    indexSecond++;
                    while (commonElements.size() > 0 && secondChar!=commonElements.peekFirst()) {
                        indexFirst--;
                        commonElements.removeFirst();
                }
            } else {
                if (commonElements.size() > 0 && commonElements.peekFirst() == s3.charAt(indexResult)) {
                    commonElements.removeFirst();
                } else {
                    return false;
                }
            }
            indexResult++;
        }
        return true;
    }
}
