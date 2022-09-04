package com.cyryl.daily.september;

import com.cyryl.structures.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class VerticalOrder {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        PriorityQueue<Position> priorityQueue = new PriorityQueue<>();
        setPositions(priorityQueue, root, 0, 0);

        List<List<Integer>> result = new ArrayList<>();
        Position currColPos = priorityQueue.peek();
        List<Integer> colValues = new ArrayList<>();

        while (!priorityQueue.isEmpty()) {
            Position position = priorityQueue.poll();
            if(currColPos.col != position.col){
                result.add(colValues);
                colValues = new ArrayList<>();
                currColPos = position;
            }
            colValues.add(position.node.val);
        }
        result.add(colValues);
        return result;
    }

    public void setPositions(PriorityQueue<Position> pq, TreeNode curr, int row, int col) {
        if (curr == null) {
            return;
        }
        pq.add(new Position(row, col, curr));
        setPositions(pq, curr.left, row + 1, col - 1);
        setPositions(pq, curr.right, row + 1, col + 1);
    }

    private class Position implements Comparable<Position> {
        int row;
        int col;
        TreeNode node;

        Position(int row, int col, TreeNode node) {
            this.row = row;
            this.col = col;
            this.node = node;
        }


        @Override
        public int compareTo(Position other) {
            if (this.col != other.col) {
                return Integer.compare(this.col, other.col);
            }
            if (this.row != other.row) {
                return Integer.compare(this.row, other.row);
            }
            return Integer.compare(this.node.val, other.node.val);
        }
    }
}
