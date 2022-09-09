package com.cyryl.coderbyte;

import java.util.HashMap;
import java.util.Map;

public class TreeConstruct {

    private static class Node {
        int val;
        Node left;
        Node right;
        Node parent;

        Node(int val) {
            this.val = val;
        }

        boolean addChild(Node node) {
            if (node.parent == null) {
                node.parent = this;
            } else {
                return false;
            }
            if (left == null) {
                left = node;
                return true;
            } else if (right == null) {
                right = node;
                return true;
            } else {
                return false;
            }
        }
    }

    public static String TreeConstructor(String[] strArr) {

        Map<Integer, Node> nodes = new HashMap<>();

        for (int i = 0; i < strArr.length; i++) {
            String[] parts = strArr[i].replaceAll("\\(|\\)", "").split(",");
            int child = Integer.parseInt(parts[0]);
            int parent = Integer.parseInt(parts[1]);

            Node childNode = nodes.getOrDefault(child, new Node(child));
            Node parentNode = nodes.getOrDefault(parent, new Node(parent));

            if (!parentNode.addChild(childNode)) {
                return "false";
            }
            nodes.put(child, childNode);
            nodes.put(parent, parentNode);
        }
        Node root = nodes.values().iterator().next();
        while (root.parent != null) {
            root = root.parent;
        }
        return countNodes(root) == nodes.size() ? "true" : "false";
    }

    private static int countNodes(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + countNodes(node.left) + countNodes(node.right);
    }
}
