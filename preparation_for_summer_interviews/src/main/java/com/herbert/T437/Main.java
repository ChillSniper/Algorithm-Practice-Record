package com.herbert.T437;
import com.herbert.Utils.TreeNode;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private int ans;
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> cnt = new HashMap<>();
        ans = 0;
        cnt.merge(0l, 1, Integer::sum);
        dfs(root, targetSum, cnt, 0l);
        return ans;
    }

    private void dfs(TreeNode root, int targetSum, Map<Long, Integer> cnt, long cur) {
        if (root == null)
            return ;
        long t = cur + root.val;
        ans += cnt.getOrDefault(t - targetSum, 0);
        cnt.merge(t, 1, Integer::sum);
        dfs(root.left, targetSum, cnt, t);
        dfs(root.right, targetSum, cnt, t);
        cnt.merge(t, -1, Integer::sum);
    }
}
