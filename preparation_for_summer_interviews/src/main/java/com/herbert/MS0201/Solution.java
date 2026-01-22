package com.herbert.MS0201;
import com.herbert.Utils.ListNode;

public class Solution {
    public ListNode removeDuplicateNodes(ListNode head) {
        ListNode preHead = new ListNode(-1, head);
        int[] r = new int[20000];
        ListNode t = head, cur = preHead;
        while (t != null) {
            int x = t.val;
            if (r[x] == 1) {
                t = t.next;
                
            } else {
                r[x] = 1;
                cur.next = t;
                cur = cur.next;
                t = t.next;
            }
        }
        cur.next = null;
        // return preHead.next;
        return preHead.next;
    }
}

