#include <iostream>
#include <bits/stdc++.h>
using namespace std;

struct TreeNode {
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int _val, TreeNode* _lf, TreeNode* _ri): val(_val), left(_lf), right(_ri) {

    }
};

vector<vector<int>> solve(TreeNode* root) {
    if (root == nullptr) {
        return {};
    }
    deque<TreeNode*> dq;
    dq.push_back(root);
    vector<vector<int>> ans;
    while (!dq.empty()) {
        int sz = dq.size();
        vector<int> cur(sz, 0);
        for (int i = 0;i < sz;i ++) {
            TreeNode* t = dq.front();
            dq.pop_front();
            cur[i] = t->val;
            if (t->left != nullptr) {
                dq.push_back(t->left);
            }
            if (t->right != nullptr) {
                dq.push_back(t->right);
            }
        }
        ans.push_back(cur);
    }
    return ans;
}

int main() {
    TreeNode* root = new TreeNode(3, nullptr, nullptr);
    TreeNode* r9 = new TreeNode(9, nullptr, nullptr);
    TreeNode* r20 = new TreeNode(20, nullptr, nullptr);
    TreeNode* r15 = new TreeNode(15, nullptr, nullptr);
    TreeNode* r7 = new TreeNode(7, nullptr, nullptr);   
    root->left = r9;
    root->right = r20;
    r20->left = r15;
    r20->right = r7;
    vector<vector<int>> ans = solve(root);
    for (int i = 0;i < ans.size();i ++) {
        int sz = ans[i].size();
        for (int j = 0;j < sz;j ++) {
            cout << ans[i][j] << " ";
        }
        cout << endl;
    }
    return 0;
}