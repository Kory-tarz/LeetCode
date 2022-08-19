package com.cyryl.neetcode150.linkedlist;

public class RemoveNth {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 1;

        int len = getLength(head);

        ListNode curr = head;
        ListNode prev = null;

        while (count < len - n){
            count++;
            prev = curr;
            curr = curr.next;
        }
        if(prev == null){
            return head.next;
        }
        prev.next = curr.next;
        return head;
    }

    public int getLength(ListNode head){
        int count = 0;
        while (head != null){
            count++;
            head = head.next;
        }
        return count;
    }
}
