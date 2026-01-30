package com.herbert.MS0206;


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
    public boolean isPalindrome(ListNode head) {
        // reverse the last half nodes
        ListNode preNode = new ListNode(-1, head);
        int cnt = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            ++ cnt;
        }
        ListNode sl = head, fs = preNode;
        int hfDis = (cnt + 1) / 2;
        while (hfDis > 0) {
            fs = fs.next;
            -- hfDis;
        }
        ListNode fsStart = reverseList(fs.next);
        fs.next = fsStart;
        hfDis = cnt / 2;
        while (hfDis != 0) {
            if (sl.val != fsStart.val) 
                return false;
            sl = sl.next;
            fsStart = fsStart.next;
            -- hfDis;
        }
        return true;
    }

    private ListNode reverseList(ListNode head) {
        ListNode top = null, cur = head;
        while (cur != null) {
            ListNode nxt = cur.next;
            cur.next = top;
            top = cur;
            cur = nxt;
        }
        return top;
    }
}