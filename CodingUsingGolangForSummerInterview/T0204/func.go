package main

type ListNode struct {
	Val  int
	Next *ListNode
}

func partition(head *ListNode, x int) *ListNode {
	fsHead := &ListNode{Val: -1, Next: nil}
	slHead := &ListNode{Val: -1, Next: nil}
	cur, slCur, fsCur := head, slHead, fsHead
	for cur != nil {
		nxt := cur.Next
		cur.Next = nil
		if cur.Val < x {
			slCur.Next = cur
			slCur = slCur.Next

		} else {
			fsCur.Next = cur
			fsCur = fsCur.Next
		}
		cur = nxt
	}
	slCur.Next = fsHead.Next
	return slHead.Next
}
