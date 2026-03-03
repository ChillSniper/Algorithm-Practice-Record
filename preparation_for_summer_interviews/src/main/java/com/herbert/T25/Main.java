package com.herbert.T25;

import com.herbert.Utils.ListNode;

public class Main {
    
    public ListNode reverseKGroup(ListNode head, int k) {
        // int cnt = 0;
        // while (cnt < 10) {
        //     ++ cnt;
        // }
        ListNode preHead = new ListNode(-1, head);
        ListNode cur = preHead, pre = null;
        while (cur != null) {
            int cnt = 0;
            ListNode r = cur;
            while (cnt < k + 1 && cur != null) {
                ++ cnt;
                pre = cur;
                cur = cur.next;
            }
            if (cnt != k + 1)
                break;
            pre.next = null;
            ListNode h = r.next;
            r.next = null;
            ListNode newHead = reverseKth(h);
            r.next = newHead;
            h.next = cur;
            cur = h;
        }
        return preHead.next;
    }
    private ListNode reverseKth(ListNode head) {
        ListNode tp = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = tp;
            tp = cur;
            cur = tmp;
        }
        return tp;
    }
}

