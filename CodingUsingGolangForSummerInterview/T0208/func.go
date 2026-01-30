package main

type ListNode struct {
	Val  int
	Next *ListNode
}

func detectCycle(head *ListNode) *ListNode {
	var fs, sl *ListNode
	fs, sl = head, head
	for fs != nil && sl != nil {
		if fs.Next != nil {
			fs = fs.Next.Next
		} else {
			return nil
		}
		sl = sl.Next
		if fs == sl {
			sl = head
			for fs != sl {
				fs = fs.Next
				sl = sl.Next
			}
			return fs
		}
	}
	return nil
}
