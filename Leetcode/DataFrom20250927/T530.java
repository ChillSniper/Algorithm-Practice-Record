public class T530 {
    private int ans;
    TreeNode pre;
    public int getMinimumDifference(TreeNode root) {
        ans = Integer.MAX_VALUE;
        pre = null;   
        dfs(root);
        return ans;
    }
    private void dfs(TreeNode root) {
        if (root == null)
            return;
        dfs(root.left);
        if (pre != null) {
            ans = Math.min(ans, root.val - pre.val);
        }
        pre = root;
        dfs(root.right);
    }
}
