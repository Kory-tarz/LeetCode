package com.cyryl.neetcode150.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class CopyList {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        Map<Node, Node> nodeReflection = new HashMap<>();

        Node node = head;
        Node deepNode;
        while (node != null){
            deepNode = new Node(node.val);
            nodeReflection.put(node, deepNode);
            node = node.next;
        }

        node = head;
        while (node != null){
            deepNode = nodeReflection.get(node);
            deepNode.next = nodeReflection.get(node.next);
            deepNode.random = nodeReflection.get(node.random);
            node = node.next;
        }
        return nodeReflection.get(head);
    }
}
