package com.cyryl.daily.previous;

public class ReversedLinkedII {


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public ListNode reverseBetween(ListNode head, int left, int right) {
        int current = 1;
        ListNode node = head;
        ListNode prev = null;
        while (current < left) {
            prev = node;
            node = node.next;
            current++;
        }
        node = reverse(prev, node, node, current, right);
        if (prev != null)
            prev.next = node;

        return head;
    }

    public ListNode reverse(ListNode prev, ListNode first, ListNode node, int current, int end) {
        if (current > end) {
            first.next = node;
            return prev;
        }
        ListNode next = node.next;
        node.next = prev;
        current++;
        return reverse(node, first, next, current, end);
    }
}
