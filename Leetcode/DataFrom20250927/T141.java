


public class T141 {
    public boolean hasCycle(ListNode head) {
        if(head == null)
            return false;
        ListNode PreHead = new ListNode(-1);
        PreHead.next = head;
        ListNode fast = PreHead, slow = PreHead;
        while (fast != null && slow != null) {
            if(fast.next == null)
                return false;
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow)
                return true;
        }        
        return false;
    }
}