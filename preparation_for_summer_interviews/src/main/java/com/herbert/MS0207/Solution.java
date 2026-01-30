package com.herbert.MS0207;
import com.herbert.Utils.ListNode;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lx = 0, ly = 0;
        ListNode cur = headA;
        while (cur != null) {
            ++ lx;
            cur = cur.next;
        }
        cur = headB;
        while (cur != null) {
            ++ ly;
            cur = cur.next;
        }
        if (lx > ly) {
            int dieta = lx - ly;
            
            while (dieta > 0) {
                -- dieta;
                headA = headA.next;
            }
        }
        if (ly > lx) {
            int dieta = ly - lx;
            while (dieta > 0) {
                -- dieta;
                headB = headB.next;
            }
        }
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        
        return null;
    }
}