

public class T19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 这个b题也就是要找到这个链表的倒数第n + 1个节点，然后把last n个node给去掉
        // sl and fs
        ListNode pre = new ListNode(-1, head);
        ListNode sl = pre, fs = pre;
        int cnt = 0;
        
        while (cnt < n) {
            fs = fs.next;
            ++ cnt;
        }
        while (fs != null) {
            fs = fs.next;
            sl = sl.next;
        }
        if (sl.next != null)
            sl.next = sl.next.next;
        else 
            sl.next = null;
        return pre.next;
    }
}
