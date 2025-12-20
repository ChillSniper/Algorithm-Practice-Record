import java.util.PriorityQueue;

public class T23 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> {return a.val - b.val;});
        ListNode preHead = new ListNode(-1);
        int n = lists.length;
        for (int i = 0;i < n;i ++) {
            pq.add(lists[i]);
        }
        ListNode cur = preHead;
        while (!pq.isEmpty()) {
            ListNode t = pq.poll();
            cur.next = t;
            cur = t;
            if (t.next != null)
                pq.add(t.next);
        }
        return preHead.next;
    }
}
