package com.cyryl.daily.year2023.august;

import com.cyryl.neetcode150.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;


public class GenerateTrees {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> result = generate(1, n);
        return result;
    }

    private List<TreeNode> generate(int left, int right) {
        List<TreeNode> nodes = new ArrayList<>();
        if (right < left) {
            nodes.add(null);
            return nodes;
        }
        if (left == right) {
            nodes.add(new TreeNode(left));
            return nodes;
        }
        for (int nextNode = left; nextNode <= right; nextNode++) {
            List<TreeNode> rightNodes = generate(nextNode + 1, right);
            List<TreeNode> leftNodes = generate(left, nextNode - 1);
            for (TreeNode rightNode : rightNodes) {
                for (TreeNode leftNode : leftNodes) {
                    TreeNode node = new TreeNode(nextNode);
                    node.right = rightNode;
                    node.left = leftNode;
                    nodes.add(node);
                }
            }
        }
        return nodes;
    }
}
