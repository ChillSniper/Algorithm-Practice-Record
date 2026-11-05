#include <bits/stdc++.h>
using namespace std;

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */

struct ListNode {
public:
    int val;
    ListNode* next;
    ListNode(): val(0), next(nullptr) {}
    ListNode(int x): val(x), next(nullptr) {}
    ListNode(int x, ListNode* next): val(x), next(next) {}
};

class Solution {
public:
    void reorderList(ListNode* head) {
        ListNode* preHead = new ListNode(-1, head);
        // -1 1 2 3 4
        int len = 0;
        ListNode* cur = head;
        while (cur != nullptr) {
            ++ len;
            cur = cur->next;
        }
        int halfLen = (len + 1) / 2;
        ListNode* pre = preHead;
        cur = head;
        while (halfLen > 0) {
            cur = cur->next;
            pre = pre->next;
            -- halfLen;
        }
        pre->next = nullptr;

        ListNode* LastHead = reverseList(cur);
        ListNode* firstHead = preHead->next;
        preHead->next = nullptr;
        cur = preHead;

        while (LastHead != nullptr || firstHead != nullptr) {
            if (firstHead) {
                cur->next = firstHead;
                cur = cur->next;
            }
            if (LastHead) {
                cur->next = LastHead;
                cur = cur->next;
            }
        }
        cur->next = nullptr;


    }
private:
    ListNode* reverseList(ListNode* head) {
        ListNode* cur = nullptr;
        while (head != nullptr) {
            ListNode* tmp = head->next;
            head->next = cur;
            cur = head;
            head = tmp;
        }
        return cur;
    }
};

int main() {
    return 0;
}