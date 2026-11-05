#include <iostream>
#include <bits/stdc++.h>
#define Test
using namespace std;

struct ListNode {
    int val;
    ListNode* next;
    ListNode(int _x, ListNode* _next): val(_x), next(_next){}
    ListNode(int _x): val(_x), next(nullptr){}
    ListNode(): val(-1), next(nullptr){}
};

ListNode* reverse(ListNode* head) {
    ListNode* cur = nullptr;
    while (head) {
        ListNode* nxt = head->next;
        head->next = cur;
        cur = head;
        head = nxt;
    }
    return cur;
    // return head;
}

int main() {
    #ifdef Test
        freopen("file.in", "r", stdin);
        freopen("file.out", "w", stdout);
    #endif
    int n;
    cin >> n;
    vector<int> arr(n, 0);
    ListNode* preHead = new ListNode();
    ListNode* cur = preHead;
    for (int i = 0;i < n;i ++) {
        cin >> arr[i];
        ListNode* tmp = new ListNode(arr[i]);
        cur->next = tmp;
        cur = tmp;
    }
    int k;
    cin >> k;
    cur = preHead;
    // ListNode* test = reverse(preHead->next);
    // while (test != nullptr) {
    //     cout << test->val;
    //     test = test->next;
    // }
    while (cur != nullptr && cur->next != nullptr) {
        ListNode* goNode = cur;
        for (int i = 0;i < k && goNode != nullptr;i ++) {
            // cout << goNode->val << endl;
            goNode = goNode->next;
            
        }
        ListNode* goNodeNxt = nullptr;
        if (goNode) {
            goNodeNxt = goNode->next;
            goNode->next = nullptr;
        }
        ListNode* reverseNode = cur->next;
        // cout << reverseNode->val << endl;
        cur->next = nullptr;
        ListNode* newHead = reverse(reverseNode);
        
        // cout << newHead->val << endl;
        cur->next = newHead;
        reverseNode->next = goNodeNxt;
        cur = reverseNode;
    }
    while (preHead->next != nullptr) {
        cout << preHead->next->val;
        preHead = preHead->next;
    }
    return 0;
}