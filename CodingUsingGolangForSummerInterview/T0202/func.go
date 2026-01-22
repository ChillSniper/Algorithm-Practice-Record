package main

type ListNode struct {
	Val  int
	Next *ListNode
}

func kthToLast(head *ListNode, k int) int {
	cnt := 0
	preHead := &ListNode{Val: -1, Next: head}
	sl, fs := preHead, preHead
	for cnt < k {
		cnt++
		fs = fs.Next
	}
	for fs != nil {
		fs = fs.Next
		sl = sl.Next
	}
	return sl.Val
}
