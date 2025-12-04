package com.cyryl.daily.year2025.november;

public class DigitRemover {
    public String removeKdigits(String num, int k) {
        StringBuilder sb = new StringBuilder();
        char[] digits = num.toCharArray();
        for (int i = 0; i < digits.length; i++) {
            while (!sb.isEmpty() && k > 0 && digits[i] < sb.charAt(sb.length() - 1)) {
                sb.deleteCharAt(sb.length() - 1);
                k--;
            }
            if (!(sb.isEmpty() && digits[i] == '0')) {
                sb.append(digits[i]);
            }
        }
        if (k >= sb.length()) {
            return "0";
        }
        return sb.substring(0, sb.length() - k);
    }
}
