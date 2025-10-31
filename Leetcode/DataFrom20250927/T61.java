public class T61 {
    public ListNode rotateRight(ListNode head, int k) {
        int n = 0;
        ListNode p = head, last = null;
        while (p != null) {
            ++ n;
            if (p.next == null)
                last = p;
            p = p.next;

        }   
        k %= n;
        int s = n - k;
        ListNode pre = new ListNode(-1, head);
        ListNode cur = pre;
        while (s > 0) {
            cur = cur.next;
            -- s;
        }
        last.next = pre.next;
        pre.next = cur.next;
        cur.next = null;
        return pre.next;
    }  
}
