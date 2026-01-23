package main

type ListNode struct {
	Val  int
	Next *ListNode
}

func deleteNode(node *ListNode) {
	var pre *ListNode = nil
	cur := node
	for cur.Next != nil {
		cur.Val = cur.Next.Val
		pre = cur
		cur = cur.Next
	}
	pre.Next = nil
}
