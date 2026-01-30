package com.herbert.T133;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

import com.herbert.Utils.Node;

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) 
            return null;
        // 好久没写n图论的代码都快忘干净了，确实需要再练练
        // 很抽象，怎么理清边与边之间的关系？
        HashMap<Integer, Node> record = new HashMap<>();
        // bfs
        Deque<Node> dq = new ArrayDeque<>();
        dq.add(node);
        while (!dq.isEmpty()) {
            Node t = dq.pollFirst();
            record.put(node.val, node);
            int sz = t.neighbors.size();
            for (int i = 0;i < sz;i ++) {
                Node g = t.neighbors.get(i);
                if (record.containsKey(g.val)) {
                    continue;
                }
                dq.add(g);
                record.put(g.val, g);
            }
        }
        System.out.println(record.size());
        HashMap<Integer, Node> newNodeRecord = new HashMap<>();
        Node ansNode = new Node(node.val);
        dq.add(ansNode);
        while (!dq.isEmpty()) {
            Node newNode = dq.pollFirst();
            Node oriNode = record.get(newNode.val);
            // sz judge
            newNodeRecord.put(newNode.val, newNode);
            int sz = oriNode.neighbors.size();
            if (newNode.neighbors.size() == sz) {
                continue;
            }
            for (int i = 0;i < sz;i ++) {
                Node oriNeiNode = oriNode.neighbors.get(i);
                int oriVal = oriNeiNode.val;
                if (newNodeRecord.containsKey(oriVal)) {
                    newNode.neighbors.add(newNodeRecord.get(oriVal));
                    dq.add(newNodeRecord.get(oriVal));
                    continue;
                }
                Node newOriValNode = new Node(oriVal);
                dq.add(newOriValNode);
                newNode.neighbors.add(newOriValNode);
                newNodeRecord.put(newOriValNode.val, newOriValNode);
            }
        }
        
        return ansNode;
    }
}