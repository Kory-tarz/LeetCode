package com.cyryl.neetcode150.linkedlist;


/**
 * https://leetcode.com/problems/reorder-list/
 */

public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        int len = findLen(head);
        int mid = (len + 1) >> 1;
        ListNode tailHead = getEndPartHead(head, mid);
        ListNode other = reverse(tailHead);
        ListNode node = head;

        while (node != null && other != null){
            ListNode tempNode = node.next;
            ListNode tempOther = other.next;

            node.next = other;
            other.next = tempNode;

            node = tempNode;
            other = tempOther;
        }
    }

    private ListNode reverse(ListNode node){
        ListNode prev = null;
        ListNode curr = node;
        ListNode next = node.next;

        while (next != null){
            curr.next = prev;
            prev = curr;
            curr = next;
            next = next.next;
        }
        curr.next = prev;
        return curr;
    }

    private ListNode getEndPartHead(ListNode node, int mid){
        int count = 1;
        while (count != mid){
            node = node.next;
            count++;
        }
        return node.next;
    }

    private int findLen(ListNode node) {
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }
}
