import java.util.*;

class LRUCache {

    // 通过key -> node -> node.val
    Map<Integer, SpNode> record;
    int capacity;
    SpNode PreHead, LastTail;

    public LRUCache(int capacity) {
        // md我想起来了，这个b题麻烦得很，要维护一个双向链表
        // 头尾各自设置一个哨兵节点
        // 今天不想写这b玩意了，等明天再写吧
        this.capacity = capacity;
        record = new HashMap<>();
        PreHead = new SpNode(-1, -1);
        LastTail = new SpNode(-1, -1);
        PreHead.after = LastTail;
        LastTail.before = PreHead;
    }
    
    public int get(int key) {
        if (record.containsKey(key)) {
            SpNode target = Remove(key);
            InsertAtHead(target);
            record.put(key, target);
            return record.get(key).value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        // first check node is exist ?
        if (record.containsKey(key)) {
            SpNode target = Remove(key);

            target.value = value;
            InsertAtHead(target);
            record.put(key, target);
        } else {
            if (capacity <= 0) {
                Remove(LastTail.before.key);
                ++ capacity;
            }
            --capacity;
            SpNode cur = new SpNode(key, value);
            InsertAtHead(cur);
            record.put(key, cur);
        }
    }
    private void InsertAtHead(SpNode cur) {
        // no cap
        SpNode nxt = PreHead.after;
        PreHead.after = cur;
        cur.before = PreHead;
        cur.after = nxt;
        nxt.before = cur;
    }
    private SpNode Remove(int key) {
    
        SpNode target = record.get(key);
        SpNode bf = target.before;
        SpNode nxt = target.after;
        target.before = null;
        target.after = null;
        bf.after = nxt;
        nxt.before = bf;
        record.remove(key);
        return target;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */