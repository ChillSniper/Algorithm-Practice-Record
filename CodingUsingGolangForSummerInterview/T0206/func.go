package main

type ListNode struct {
	Val  int
	Next *ListNode
}

func isPalindrome(head *ListNode) bool {
	var cnt int
	cur := head
	for cur != nil {
		cnt++
		cur = cur.Next
	}
	preHead := &ListNode{Val: -1, Next: head}
	sl, fs := head, preHead
	halfDis := (cnt + 1) / 2
	for halfDis > 0 {
		halfDis--
		fs = fs.Next
	}
	nxt := reverse(fs.Next)
	fs.Next = nxt
	halfDis = cnt / 2
	for halfDis > 0 {
		if sl.Val != nxt.Val {
			return false
		}
		sl = sl.Next
		nxt = nxt.Next
		halfDis--
	}
	return true
}

func reverse(head *ListNode) *ListNode {
	var top, cur *ListNode
	top, cur = nil, head
	for cur != nil {
		nxt := cur.Next
		cur.Next = top
		top = cur
		cur = nxt
	}
	return top
}
