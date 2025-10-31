
public class T92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode PreHead = new ListNode(-1, head);
        ListNode fs = PreHead, sl = PreHead;
        int i = 0;
        while (i < left - 1) {
            sl = sl.next;
            fs = fs.next;
            ++ i;
        }
        while (i < right + 1) {
            fs = fs.next;
            ++ i;
        }

        ListNode record = sl.next, cur = record.next;
        record.next = fs;
        i = left + 1;
        while (i <= right) {
            ListNode nxt = cur.next;
            cur.next = record;
            record = cur;
            cur = nxt;
            i ++;            
        }
        sl.next = record;
        return PreHead.next;
    }
}
