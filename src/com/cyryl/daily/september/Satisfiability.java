package com.cyryl.daily.september;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/satisfiability-of-equality-equations/
 */

public class Satisfiability {

    private final static int LEFT_SYMBOL = 0;
    private final static int OPERATOR = 1;
    private final static int RIGHT_SYMBOL = 3;
    private final static int NR_OF_LETTERS = 26;


    public boolean equationsPossible(String[] equations) {
        UnionFind unionFind = new UnionFind();

        for (String equation : equations) {
            if (equation.charAt(OPERATOR) == '=') {
                unionFind.createUnion(equation.charAt(LEFT_SYMBOL), equation.charAt(RIGHT_SYMBOL));
            }
        }
        for (String equation : equations) {
            boolean isUnion = unionFind.isUnion(equation.charAt(LEFT_SYMBOL), equation.charAt(RIGHT_SYMBOL));
            if (equation.charAt(OPERATOR) == '=' && !isUnion) {
                return false;
            }
            if (equation.charAt(OPERATOR) == '!' && isUnion) {
                return false;
            }
        }
        return true;
    }

    class UnionFind {
        private int[] parent;
        private int[] rank;

        public UnionFind() {
            parent = new int[NR_OF_LETTERS];
            rank = new int[NR_OF_LETTERS];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
        }

        public boolean isUnion(char a, char b) {
            return findParent(charToInt(a)) == findParent(charToInt(b));
        }

        public void createUnion(char a, char b) {
            int parA = findParent(charToInt(a));
            int parB = findParent(charToInt(b));

            if (rank[parA] > rank[parB]) {
                parent[parB] = parA;
            } else if (rank[parB] > rank[parA]) {
                parent[parA] = parB;
            } else {
                rank[parA]++;
                parent[parB] = parA;
            }
        }

        public int findParent(int v) {
            if (parent[v] != v) {
                parent[v] = findParent(parent[v]);
                return parent[v];
            }
            return v;
        }

        private int charToInt(char c) {
            return c - 'a';
        }
    }
}
