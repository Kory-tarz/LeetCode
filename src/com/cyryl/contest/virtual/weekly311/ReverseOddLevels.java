package com.cyryl.contest.virtual.weekly311;

import com.cyryl.structures.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class ReverseOddLevels {
    public TreeNode reverseOddLevels(TreeNode root) {
        int currLevel = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> nextLevel = new LinkedList<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if(currLevel % 2 == 0){
                if(curr.left != null) {
                    stack.offerFirst(curr.left.val);
                    stack.offerFirst(curr.right.val);
                }
            } else {
                curr.val = stack.pollFirst();
            }
            if(curr.left != null) {
                nextLevel.offer(curr.left);
                nextLevel.offer(curr.right);
            }
            if (queue.isEmpty()) {
                currLevel++;
                queue = nextLevel;
                nextLevel = new LinkedList<>();
            }
        }
        return root;
    }
}
