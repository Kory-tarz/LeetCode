package com.cyryl.medium;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegion {

    public void solve(char[][] board) {

        Queue<Point> borderPoints = findAllBorderPoints(board);
        boolean[][] visited = visitAllConnectedPoints(board, borderPoints);
        replaceAllCapturedPoints(board, visited);

    }

    private boolean[][] visitAllConnectedPoints(char[][] board, Queue<Point> borderPoints) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        Point currentPoint;

        while(!borderPoints.isEmpty()){
            currentPoint = borderPoints.poll();
            visited[currentPoint.x][currentPoint.y] = true;

            if(currentPoint.x+1 < board.length && !visited[currentPoint.x+1][currentPoint.y] && board[currentPoint.x+1][currentPoint.y] == 'O')
                borderPoints.offer(new Point(currentPoint.x+1, currentPoint.y));
            if(currentPoint.y+1 < board[0].length && !visited[currentPoint.x][currentPoint.y+1] && board[currentPoint.x][currentPoint.y+1] == 'O')
                borderPoints.offer(new Point(currentPoint.x, currentPoint.y+1));

            if(currentPoint.x-1 > 0 && !visited[currentPoint.x-1][currentPoint.y] && board[currentPoint.x-1][currentPoint.y] == 'O')
                borderPoints.offer(new Point(currentPoint.x-1, currentPoint.y));
            if(currentPoint.y-1 > 0 && !visited[currentPoint.x][currentPoint.y-1] && board[currentPoint.x][currentPoint.y-1] == 'O')
                borderPoints.offer(new Point(currentPoint.x, currentPoint.y-1));

        }
        return visited;
    }

    private Queue<Point> findAllBorderPoints(char[][] board){
        Queue<Point> points = new LinkedList<>();
        Point cell;

        for(int i=0; i<board.length; i++){
            if(board[i][0] == 'O') {
                cell = new Point(i, 0);
                points.offer(cell);
            }
            if(board[i][board[0].length-1] == 'O'){
                cell = new Point(i, board[0].length-1);
                points.offer(cell);
            }
        }

        for(int j=1; j<board[0].length-1; j++){
            if(board[0][j] == 'O'){
                cell = new Point(0, j);
                points.offer(cell);
            }
            if(board[board.length-1][j] == 'O'){
                cell = new Point(board.length-1, j);
                points.offer(cell);
            }
        }
        return points;
    }

    private void replaceAllCapturedPoints(char[][] board, boolean[][] visited) {
        for(int i=0; i<board.length; i++)
            for(int j=0; j< board[0].length; j++)
                if (board[i][j] == 'O' && !visited[i][j])
                    board[i][j] = 'X';
    }
}
