
public class T25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        // 这个我好像有印象怎么做来着，每次将k个翻转那个操作可以提取出一个函数来
        // 但是不是很想写这个，这种题太sb了
        // 这个实际上是上题翻转链表的变式，这种东西处理起来非常头疼
        // 开干！
        ListNode preHead = new ListNode(-1, head);
        ListNode sl = preHead, fs = preHead.next;
        while (true) {
            int cnt = 0;
            boolean flag = false;
            while (cnt < k) {
                if (fs == null) {
                    flag = true;
                    break;
                }
                fs = fs.next;
                ++ cnt;
            }
            if (flag)
                break;
            f(sl, fs);
            cnt = 0;
            while (cnt < k) {
                if (sl == null) {
                    flag = true;
                    break;
                }
                sl = sl.next;
                ++ cnt;
            }
            if (flag)
                break;
        }
        return preHead.next;
    }
    private void f(ListNode pre, ListNode lst) {
        ListNode cur = pre.next.next, fr = pre.next;
        fr.next = lst;
        while (cur != lst) {
            ListNode tmp = cur.next;
            cur.next = fr;
            fr = cur;
            cur = tmp;
        }
        pre.next = fr;
    }
}
