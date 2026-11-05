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
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}    
};

class Solution {
public:
    ListNode* sortList(ListNode* head) {
        // 1 2 3 4 5
        // 1 2 3 4 
        // simple is fast
        auto [leftNode, rightNode] = splitList(head);
        leftNode = MergeSort(leftNode);
        rightNode = MergeSort(rightNode);
        ListNode* ans = MergeTwoList(leftNode, rightNode);

        return ans;
    }
    std::pair<ListNode*, ListNode*> splitList(ListNode* head) {
        ListNode* fs = head;
        ListNode* sl = head;
        if (head == nullptr) {
            return {nullptr, nullptr};
        }
        while (fs->next && fs->next->next) {
            fs = fs->next->next;
            sl = sl->next;
        }
        ListNode* rightNode = sl->next;
        sl->next = nullptr;
        return {head, rightNode};
    }
    ListNode* MergeSort(ListNode* head) {
        if (head == nullptr) 
            return head;
        if (head->next == nullptr) {
            return head;
        }
        if (head->next->next == nullptr) {
            ListNode* left = head;
            ListNode* right = head->next;
            if (left->val <= right->val) {
                return head;
            } else {
                left->next = nullptr;
                right->next = left;
                return right;
            }
        }
        auto [left, right] = splitList(head);
        ListNode* l = MergeSort(left);
        ListNode* r = MergeSort(right);
        return MergeTwoList(l, r);
    }
    ListNode* MergeTwoList(ListNode* HeadA, ListNode* HeadB) {
        ListNode* preHead = new ListNode(-1);
        ListNode* cur = preHead;
        while (HeadA && HeadB) {
            if (HeadA->val <= HeadB->val) {
                cur->next = HeadA;
                cur = cur->next;
                HeadA = HeadA->next;
            } else {
                cur->next = HeadB;
                cur = cur->next;
                HeadB = HeadB->next;
            }
        }
        if (HeadA) {
            cur->next = HeadA;
        }
        if (HeadB) {
            cur->next = HeadB;
        }
        return preHead->next;
    }
};