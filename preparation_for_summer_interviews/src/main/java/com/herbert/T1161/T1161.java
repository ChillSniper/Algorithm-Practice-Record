package com.herbert.T1161;
import java.util.ArrayDeque;
import java.util.Deque;

import com.herbert.Utils.TreeNode;

public class T1161 {
    public int maxLevelSum(TreeNode root) {
        int cur = root.val, ans = 0, cnt = 1;
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.add(root);
        while (!dq.isEmpty()) {
            ++ cnt;
            int sz = dq.size(), t = 0;
            for (int i = 0;i < sz;i ++) {
                TreeNode f = dq.pollFirst();
                t += f.val;
                if (f.left != null) {
                    dq.addLast(f.left);
                }
                if (f.right != null) {
                    dq.addLast(f.right);
                }
            }
            if (t > cur) {
                cur = t;
                ans = cnt;
            }
        }
        return ans;
    }
}
