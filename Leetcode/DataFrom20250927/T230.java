
public class T230 {
    private int k;
    private int ans;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return ans;
    }
    private void dfs(TreeNode root) {
        if (root == null || k == 0)
            return ;
        dfs(root.left);
        if (-- k == 0) {
            ans = root.val;
        }
        dfs(root.right);
    }
}
