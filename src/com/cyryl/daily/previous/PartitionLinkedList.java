package com.cyryl.daily.previous;

public class PartitionLinkedList {

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

    public ListNode partition(ListNode head, int x) {
        ListNode lastSmaller = null;
        ListNode firstGreater = null;
        ListNode lastGreater = null;
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next;
            if (current.val < x) {
                if (lastSmaller != null) {
                    lastSmaller.next = current;
                } else {
                    head = current;
                }
                lastSmaller = current;
            } else {
                if (lastGreater == null) {
                    lastGreater = current;
                    firstGreater = current;
                } else {
                    lastGreater.next = current;
                    lastGreater = current;
                }
                lastGreater.next = null;
            }
            current = next;
        }
        if (lastSmaller != null) {
            lastSmaller.next = firstGreater;
        } else {
            head = firstGreater;
        }
        return head;
    }
}
