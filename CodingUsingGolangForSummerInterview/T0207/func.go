package main

type ListNode struct {
	Val  int
	Next *ListNode
}

func getIntersectionNode(headA, headB *ListNode) *ListNode {
	var lx, ly int
	var curx, cury *ListNode
	curx, cury = headA, headB
	for curx != nil {
		curx = curx.Next
		lx++
	}
	for cury != nil {
		cury = cury.Next
		ly++
	}
	curx, cury = headA, headB
	if lx > ly {
		dieta := lx - ly
		for dieta > 0 {
			curx = curx.Next
			dieta--
		}
	}
	if lx < ly {
		dieta := ly - lx
		for dieta > 0 {
			cury = cury.Next
			dieta--
		}
	}
	for curx != nil && cury != nil {
		if curx == cury {
			return curx
		}
		curx = curx.Next
		cury = cury.Next
	}
	return nil
}
