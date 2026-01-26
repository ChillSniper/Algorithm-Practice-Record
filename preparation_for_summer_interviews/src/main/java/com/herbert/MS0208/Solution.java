package com.herbert.MS0208;

import com.herbert.Utils.ListNode;

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode prehead = new ListNode(-1, head);
        ListNode fs = head, sl = head;
        // 这个推导非常抽象
        // 如果有环，我们将链表分成三段：a + b + c
        // so 2 * (a + b) = a + b + n * (b + c)
        // so a = c + (n - 1)(b + c)

        while (fs != null && sl != null) {
            if (fs.next != null) {
                fs = fs.next.next;
            } else {
                return null;
            }
            sl = sl.next;
            if (fs == sl) {
                sl = head;
                while (sl != fs) {
                    sl = sl.next;
                    fs = fs.next;
                }
                return sl;
            }
        }

        return null;
    }
}
