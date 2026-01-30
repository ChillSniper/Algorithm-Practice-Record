package com.herbert.MS0203;

import com.herbert.Utils.ListNode;

public class Solution {
    public void deleteNode(ListNode node) {
        ListNode cur = node, pre = null;
        while (cur.next != null){ 
            
            // 1, 2, 3, 4, 5, 6, 7, 8
            
            cur.val = cur.next.val;
            pre = cur;
            cur = cur.next;
        }
        pre.next = null;
    }
}
