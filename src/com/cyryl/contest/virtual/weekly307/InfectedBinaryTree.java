package com.cyryl.contest.virtual.weekly307;

import com.cyryl.structures.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class InfectedBinaryTree {
    public int amountOfTime(TreeNode root, int start) {
        Set<Integer> infected = new HashSet<>();
        int rootTime = timeToInfectRoot(root, start, infected);
        System.out.println(rootTime);
        return findMaxTime(root, rootTime, infected);
    }

    public int findMaxTime(TreeNode curr, int time, Set<Integer> infected) {
        int max = time;
        int tempTime;
        if (curr.left != null) {
            if (infected.contains(curr.left.val)) {
                tempTime = time - 1;
            } else {
                tempTime = time + 1;
            }
            max = Math.max(max, findMaxTime(curr.left, tempTime, infected));
        }
        if (curr.right != null) {
            if (infected.contains(curr.right.val)) {
                tempTime = time - 1;
            } else {
                tempTime = time + 1;
            }
            max = Math.max(max, findMaxTime(curr.right, tempTime, infected));
        }
        return max;
    }

    public int timeToInfectRoot(TreeNode curr, int start, Set<Integer> infected) {
        if (curr == null) {
            return -1;
        }
        if (curr.val == start) {
            infected.add(curr.val);
            return 0;
        }
        int left = timeToInfectRoot(curr.left, start, infected);
        int right = timeToInfectRoot(curr.right, start, infected);
        if (left != -1 || right != -1) {
            infected.add(curr.val);
            return 1 + Math.max(left, right);
        } else {
            return -1;
        }
    }
}
