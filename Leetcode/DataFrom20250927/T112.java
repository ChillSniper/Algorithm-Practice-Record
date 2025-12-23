public class T112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        return dfs(root, targetSum);
    }

    private boolean dfs(TreeNode root, int cur) {
        if (root == null) {
            return cur == 0;
        }
        if (root.left == null && root.right == null && root.val == cur)
            return true;
        boolean flag = false;
        if (root.left != null) {
            flag |= dfs(root.left, cur - root.val);
        }
        if (root.right != null) {
            flag |= dfs(root.right, cur - root.val);
        }
        return flag;
    }
}
