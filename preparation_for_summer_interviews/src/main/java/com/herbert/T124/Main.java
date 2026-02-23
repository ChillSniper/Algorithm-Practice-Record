package com.herbert.T124;

import com.herbert.Utils.TreeNode;

public class Main {
    private int ans;
    public int maxPathSum(TreeNode root) {
        ans = Integer.MIN_VALUE;
        dfs(root);
        return ans;
    }
    private int dfs(TreeNode root) {
        if (root == null)
            return 0;
        int l = dfs(root.left), r = dfs(root.right);
        // we must return a branch of sum
        int t = root.val;
        t = Math.max(t, root.val + l);
        t = Math.max(t, root.val + r);
        t = Math.max(t, l + r + root.val);
        ans = Math.max(ans, t);
        int x = root.val;
        int val = Math.max(Math.max(x + l, x + r), x);
        // int val = root.val;
        // val = Math.max(val, val + l);
        // val = Math.max(val, val + r);
        return val;
    }
}
