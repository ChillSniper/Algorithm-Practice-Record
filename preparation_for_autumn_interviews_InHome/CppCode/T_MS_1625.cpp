#include <bits/stdc++.h>
using namespace std;

class Node {
    Node* before;
    Node* after;
    int value;
    Node(int _x, Node* _bf, Node* _after){
        this->value = _x;
        before = _bf;
        after = _after;
    }
};

class LRUCache {
public:
    LRUCache(int capacity) {
        
    }
    
    int get(int key) {
        
    }
    
    void put(int key, int value) {
        
    }
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */
