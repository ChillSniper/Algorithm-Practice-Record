package com.herbert.MS0205;
import com.herbert.Utils.ListNode;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int left = 0;
        ListNode curx = l1, cury = l2, prex = null, prey = null;
        while (curx != null && cury != null) {
            int cur = curx.val + cury.val + left;
            left = cur / 10;
            cur = cur % 10;
            curx.val = cur;
            prex = curx;
            prey = cury;
            curx = curx.next;
            cury = cury.next;
        }
        while(curx != null) {
            int cur = curx.val + left;
            left = cur / 10;
            cur = cur % 10;
            curx.val = cur;
            prex = curx;
            curx = curx.next;
        }
        prex.next = cury;
        while (cury != null) {
            int cur = cury.val + left;
            left = cur / 10;
            cur = cur % 10;
            cury.val = cur;
            prex = cury;
            cury = cury.next;
        }

        // remember to judge if left != 0 last
        if (left != 0) {
            prex.next = new ListNode(left);
        }
        return l1;
    }
}