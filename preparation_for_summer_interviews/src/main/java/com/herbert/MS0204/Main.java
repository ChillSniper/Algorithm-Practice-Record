package com.herbert.MS0204;

import com.herbert.Utils.ListNode;

public class Main {
    public ListNode partition(ListNode head, int x) {
        ListNode slHead = new ListNode(-1);
        ListNode fsHead = new ListNode(-1);
        ListNode cur = head, sl = slHead, fs = fsHead;
        while (cur != null) {
            ListNode nxt = cur.next;
            cur.next = null;
            if (cur.val < x) {
                sl.next = cur;
                sl = sl.next;
            } else {
                fs.next = cur;
                fs = fs.next;
            }
            cur = nxt;
        }
        sl.next = fsHead.next;
        return slHead.next;
    }
}
