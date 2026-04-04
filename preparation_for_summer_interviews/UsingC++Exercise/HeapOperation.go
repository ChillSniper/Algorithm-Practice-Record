package main

import "fmt"

struct Nodes {
	int val;
	next Nodes;
}

func f(list []Nodes) {
	pq priority_queue = new priority_queue((x, y) ->{
		return x.val - y.val;
	});
	
	var sz int;

	sz = list.size();

	for (int i = 0;i < sz; i ++) {
		if list[i] != nil {
			pq.add(list[i]);
		}
	}

	var head Nodes;
	head = new Nodes();
	var t = head;

	while (!pq.empty()) {
		tmp := pq.top();
		pq.pop();
		t.next = tmp;
		t = tmp;
		if tmp.next != nil {
			pq.add(tmp.next);
		} else {
			;
		}
	}
	return head.next;
}