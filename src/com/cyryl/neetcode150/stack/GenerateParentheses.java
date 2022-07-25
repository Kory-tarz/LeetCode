package com.cyryl.neetcode150.stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 */

public class GenerateParentheses {

    List<String> result;

    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        generate(new StringBuilder(), 0, 0, n);
        return result;
    }

    private void generate(StringBuilder sb, int open, int total, int n) {
        if(total == n){
            result.add(sb.toString());
            return;
        }
        if(open == 0){
            open++;
            sb.append('(');
            generate(sb, open, total, n);
            return;
        }
        if(open + total == n){
            open--;
            sb.append(')');
            total++;
            generate(sb, open, total, n);
            return;
        }
        // open
        StringBuilder sb2 = new StringBuilder(sb);
        sb2.append('(');
        generate(sb2, open+1, total, n);
        //close
        sb.append(')');
        generate(sb, open-1, total+1, n);
    }
}
