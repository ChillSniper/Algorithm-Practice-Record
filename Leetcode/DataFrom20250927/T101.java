public class T101 {
    public boolean isSymmetric(TreeNode root) {
        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode l, TreeNode r) {
        if (l == null && r == null)
            return true;
        if (l == null || r == null)
            return false;
        if (l.val != r.val)
            return false;
        return dfs(l.left, r.right) && dfs(l.right, r.left);
    }
}
