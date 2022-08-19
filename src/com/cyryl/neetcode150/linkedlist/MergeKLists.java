package com.cyryl.neetcode150.linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));
        ListNode dummyRoot = new ListNode();

        for (int i = 0; i < lists.length; i++) {
            if(lists[i] != null){
                minHeap.offer(lists[i]);
            }
        }
        ListNode curr = dummyRoot;
        ListNode next;

        while (!minHeap.isEmpty()){
            next = minHeap.poll();
            curr.next = next;
            if(next.next != null){
                minHeap.offer(next.next);
            }
            curr = next;
        }
        curr.next = null;
        return dummyRoot.next;
    }
}
