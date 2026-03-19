package com.herbert.LRUCache;

import java.util.HashMap;

/*
author :Herbert Lu
date: 2026.03.19
Pay attention to remove the deleted node after the func "remove()"
besides, pay attention the item "key" and "value"
we should remove the "key", not the "val", from the map
*/

class SpNode {
    SpNode pre;
    SpNode aft;
    int val;
    int key;    
    public SpNode(int key, int val) {
        this.key = key;
        this.val = val;
        pre = null;
        aft = null;
    }
    public SpNode(int key, int val, SpNode _pre, SpNode _aft) {
        this.key = key;
        this.val = val;
        pre = _pre;
        aft = _aft;
    }
    public SpNode() {
        key = - 1;
        val = - 1;
        pre = null;
        aft = null;
    }
}

class LRUCache {

    final private int containment;

    private int cur_size;

    final private SpNode Head, Tail;

    final private HashMap<Integer, SpNode> record;

    public LRUCache(int capacity) {
        this.containment = capacity;
        this.cur_size = 0;

        Head = new SpNode(-1, -1);
        Tail = new SpNode(-1, -1);
        Head.aft = Tail;
        Tail.pre = Head;
        record = new HashMap<>();
    }
    
    public int get(int key) {
        if (record.containsKey(key)) {
            SpNode t = record.get(key);

            SpNode pre = t.pre;
            SpNode nxt = t.aft;
            clear(t);
            buildConection(pre, nxt);
            InsertAfterHead(t);
            return t.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (record.containsKey(key)) {
            SpNode t = record.get(key);
            SpNode pre = t.pre;
            SpNode aft = t.aft;
            clear(t);
            buildConection(pre, aft);

            t.val = value;
            InsertAfterHead(t);
            // record.put(key, t);
        } else {
            if (cur_size >= containment) {
                remove();
            } else {
                ++ cur_size;
            }
            SpNode t = new SpNode(key, value);
            InsertAfterHead(t);
            record.put(key, t);
        }
    }

    private void InsertAfterHead(SpNode t){
        SpNode afterHead = Head.aft;
        Head.aft = t;
        t.pre = Head;
        t.aft = afterHead;
        afterHead.pre = t;
    }

    private void remove() {
        SpNode last = Tail.pre;
        SpNode second = last.pre;
        int key = last.key;
        record.remove(key);
        clear(last);
        buildConection(second, Tail);
    }

    private void clear(SpNode t) {
        t.pre = null;
        t.aft = null;
    }

    private void buildConection(SpNode pre, SpNode nxt) {
        pre.aft = nxt;
        nxt.pre = pre;
    }
}