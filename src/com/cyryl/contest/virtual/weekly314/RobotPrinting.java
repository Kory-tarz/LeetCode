package com.cyryl.contest.virtual.weekly314;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;

// 2434
public class RobotPrinting {

    private final static int IDX = 0;
    private final static int CHAR = 1;

    public String robotWithString(String s) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[CHAR] == b[CHAR] ? a[IDX] - b[IDX] : a[CHAR] - b[CHAR]);
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            pq.offer(new int[]{i, s.charAt(i)});
        }
        int lastIdx = 0;
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()){
            int[] curr = pq.poll();
            if(curr[IDX] < lastIdx){
                // value already in the stack
                continue;
            }
            while (!stack.isEmpty() && stack.peekLast() <= curr[CHAR]){
                sb.append((char)stack.pollLast());
            }
            for (int i = lastIdx; i < curr[IDX]; i++) {
                stack.offerLast(s.charAt(i));
            }
            lastIdx = curr[IDX] + 1;
            sb.append((char)curr[CHAR]);
            System.out.println(sb.toString());
        }
        while (!stack.isEmpty()){
            sb.append((char)stack.pollLast());
        }

        return sb.toString();
    }
}
