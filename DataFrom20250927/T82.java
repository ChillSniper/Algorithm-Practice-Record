
class T82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode PreHead = new ListNode(-1, head);
        ListNode cur = head, last = PreHead;
        while(cur != null) {
            int cnt = 1;
            while((cur.next != null) && (cur.next.val == cur.val)) {
                ++ cnt;
                cur = cur.next;
            }
            if(cnt == 1) {
                last = cur;
                cur = cur.next;
            }
            else {
                last.next = cur.next;
                cur = cur.next;
            }
        }
        return PreHead.next;
    }
}