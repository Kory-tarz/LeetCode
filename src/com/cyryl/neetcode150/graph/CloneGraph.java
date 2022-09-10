package com.cyryl.neetcode150.graph;

import com.cyryl.structures.graph.Node;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CloneGraph {
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        Set<Node> visited = new HashSet<>();
        Map<Integer, Node> valNode = new HashMap<>();
        Node clonedNode = new Node(node.val);
        valNode.put(clonedNode.val, clonedNode);
        cloneNodes(valNode, visited, node, clonedNode);
        return clonedNode;
    }

    private void cloneNodes(Map<Integer, Node> valNode, Set<Node> visited, Node node, Node clonedNode) {
        if(visited.contains(clonedNode)){
            return;
        }
        for (int i = 0; i < node.neighbors.size() ; i++) {
            Node neighbor = node.neighbors.get(i);
            Node clonedNeighbor = valNode.getOrDefault(neighbor.val, new Node(neighbor.val));
            clonedNode.neighbors.add(clonedNeighbor);
            valNode.putIfAbsent(clonedNeighbor.val, clonedNeighbor);
        }
        visited.add(clonedNode);
        for (int i = 0; i < clonedNode.neighbors.size(); i++) {
            cloneNodes(valNode, visited, node.neighbors.get(i), clonedNode.neighbors.get(i));
        }
    }
}
