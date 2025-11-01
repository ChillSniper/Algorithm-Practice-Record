import java.util.HashSet;
import java.util.Set;

public class T3217 {
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> record = new HashSet<>();
        for (int x : nums)
            record.add(x);
        
        ListNode preHead = new ListNode(-1, head);
        ListNode cur = preHead, t = head;
        while (t != null) {
            if (!record.contains(t.val)) {
                cur.next = t;
                cur = cur.next;
            }
            t = t.next;
        }
        return preHead.next;
    }
}
