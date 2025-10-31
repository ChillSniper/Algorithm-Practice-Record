

public class T86 {
    public ListNode partition(ListNode head, int x) {
        ListNode lower = new ListNode(-1), biger = new ListNode(-1), curLower = lower, curFast = biger;
        while (head != null) {
            if (head.val < x) {
                curLower.next = head;
                curLower = curLower.next;
            } else {
                curFast.next = head;
                curFast = curFast.next;
            }
            head = head.next;
        }
        curLower.next = biger.next;
        curFast.next = null;
        return lower.next;
    }
}
