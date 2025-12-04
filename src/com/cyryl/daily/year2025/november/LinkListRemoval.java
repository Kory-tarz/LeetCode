package com.cyryl.daily.year2025.november;

import com.cyryl.daily.previous.PartitionLinkedList;
import com.cyryl.neetcode150.linkedlist.ListNode;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class LinkListRemoval {
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> toRemove = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null) {
            if (toRemove.contains(curr.val)) {
                if (prev == null) {
                    head = curr.next;
                } else {
                    prev.next = curr.next;
                }
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
        return head;
    }
}
