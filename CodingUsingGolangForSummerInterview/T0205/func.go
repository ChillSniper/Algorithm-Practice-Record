package main

type ListNode struct {
	Val  int
	Next *ListNode
}

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	left := 0
	var curx, cury, prex *ListNode
	curx, cury = l1, l2
	for curx != nil && cury != nil {
		cur := curx.Val + cury.Val + left
		left = cur / 10
		cur %= 10
		curx.Val = cur
		prex = curx
		curx = curx.Next

		cury = cury.Next
	}
	for curx != nil {
		cur := curx.Val + left
		left = cur / 10
		cur %= 10
		curx.Val = cur
		prex = curx
		curx = curx.Next

	}
	prex.Next = cury
	for cury != nil {
		cur := cury.Val + left
		left = cur / 10
		cur %= 10
		cury.Val = cur
		prex = cury
		cury = cury.Next
	}
	if left != 0 {
		prex.Next = &ListNode{Val: left, Next: nil}
	}
	return l1
}
