import java.util.*;

class T138 {
    public Node copyRandomList(Node head) {
        // 这个题有个很粗浅的思路是开一个hashmap进行记录，
        // 但是此处的映射关系非常混乱
        // 所以这道题该怎么搞呢？
        Map<Node, Node> f = new HashMap<>();
        Node NewPreNode = new Node(-1);
        Node oldPreHead = new Node(-1);
        oldPreHead.next = head;
        Node new_t = NewPreNode;
        Node old_t = oldPreHead;
        while (old_t.next != null) {
            old_t = old_t.next;
            Node n = new Node(old_t.val);
            new_t.next = n;
            new_t = n;
            f.put(old_t, new_t);
        }
        old_t = oldPreHead;
        new_t = NewPreNode;
        while (old_t.next != null) {
            old_t = old_t.next;
            new_t = new_t.next;
            new_t.random = f.get(old_t.random);
            old_t = old_t.next;
            new_t = new_t.random;
        }
        return NewPreNode.next;
    }
}