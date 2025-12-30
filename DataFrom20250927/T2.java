

class T2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);
        int left = 0;
        ListNode t = preHead;
        while (l1 != null && l2 != null) {
            int x = l1.val + l2.val + left;
            ListNode node = new ListNode(x % 10);
            left = x / 10;
            t.next = node;
            t = node;
            l1 = l1.next;
            l2 = l2.next;
        }    
        while (l1 != null) {
            int x = l1.val + left;
            ListNode node = new ListNode(x % 10);
            left = x / 10;
            t.next = node;
            t = node;
            l1 = l1.next;
        }
        while (l2 != null) {
            int x = l2.val + left;
            ListNode node = new ListNode(x % 10);
            left = x / 10;
            t.next = node;
            t = node;
            l2 = l2.next;
        }
        if (left != 0) {
            ListNode node = new ListNode(left);
            t.next = node;
        }
        return preHead.next;
    }
    
}