package com.herbert.MS0203;

import com.herbert.Utils.ListNode;

public class Solution {
    public void deleteNode(ListNode node) {
        ListNode head = node;
        while (head.next != null) {
            if (head.next == node) {
                head.next = head.next.next;
                return ;
            }
        }
    }
}
