package main

type ListNode struct {
	Val  int
	Next *ListNode
}

func removeDuplicateNodes(head *ListNode) *ListNode {
	preHead := &ListNode{Val: -1, Next: head}
	tHead, cur := preHead, head
	r := make([]int, 20001)
	for cur != nil {
		x := cur.Val
		if r[x] == 1 {
			cur = cur.Next
		} else {
			r[x] = 1
			tHead.Next = cur
			tHead = tHead.Next
			cur = cur.Next
		}
	}
	tHead.Next = nil
	return preHead.Next
}
