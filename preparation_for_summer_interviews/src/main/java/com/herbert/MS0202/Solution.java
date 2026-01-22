package com.herbert.MS0202;

import com.herbert.Utils.ListNode;

class Solution {
    public int kthToLast(ListNode head, int k) {
        ListNode preHead = new ListNode(-1, head);
        int cnt = 0;
        ListNode fs = preHead, sl = preHead;
        while (cnt < k) {
            ++ cnt;
            fs = fs.next;
        }
        while (fs != null) {
            fs = fs.next;
            sl = sl.next;
        }
        return sl.val;
    }
}