package com.cyryl.medium;

import java.util.ArrayList;
import java.util.List;

public class Trie {

    Node head;
    private static int cumulativeValue;

    public Trie() {
        head = new Node("", 0);
        head.terminal = true;
        cumulativeValue = 1;
    }

    public void insert(String word) {
        Node node = head;
        Node tempNode;

        do{
            tempNode = node.getChild(word);
            if (tempNode == null)
                node.addChild(word);
            else if (tempNode.key.equals(word)){
                tempNode.terminal = true;
                tempNode = null;
            }
            node = tempNode;
        }while(node != null);
    }

    public boolean search(String word) {
        Node node = head;

        while(node != null){
            if(node.key.equals(word)) {
                return node.terminal;
            }
            node = node.getChild(word);
        }
        return false;
    }

    public boolean startsWith(String prefix) {
        Node node = head;

        while(node != null){
            if(node.key.equals(prefix))
                return true;
            node = node.getChild(prefix);
        }
        return false;
    }

    protected class Node{

        String key;
        List<Node> children;
        boolean terminal;
        int value;
        int level;

        public Node(String key, int level){
            this.children = new ArrayList<>();
            this.level = level;
            if(key.length() == level) {
                this.key = key;
                this.terminal = true;
                value = cumulativeValue;
            }
            else {
                this.key = key.substring(0,level);
                this.addChild(key);
            }
        }

        public void addChild(String key) {
            Node child = new Node(key, level+1);
            children.add(child);
        }

        public Node getChild(String key) {
            for(Node child : children) {
                if (child.startsWith(key)) {
                    return child;
                }
            }
            return null;
        }

        public boolean startsWith(String key) {
            return key.startsWith(this.key);
        }

//        public void setTerminal(boolean value){
//            this.terminal = value;
//        }



    }

}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

