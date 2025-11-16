public class T124Better {
    int ans;
    
    public int maxPathSum(TreeNode root) {
        ans = Integer.MIN_VALUE;
        dfs(root);
        return ans;
    }
    private int dfs(TreeNode root) {
        if (root == null)
            return 0;
        int lx = dfs(root.left);
        int rx = dfs(root.right);
        ans = Math.max(ans, root.val + lx + rx);
        int x = 0;
        x = Math.max(x, root.val + lx);
        x = Math.max(x, root.val + rx);
        x = Math.max(x, root.val);
        return x;
    }
}