public class T337 {
    
    public int rob(TreeNode root) {
        
        int[] lf = dfs(root.left);
        int[] ri = dfs(root.right);
        return Math.max(root.val + lf[1] + ri[1], lf[0] + ri[0]);
    }
    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] lf = dfs(root.left);
        int[] ri = dfs(root.right);
        // xnear, y
        int cur = Math.max(root.val + lf[1] + ri[1], lf[0] + ri[0]);
        return new int[]{cur, lf[0] + ri[0]};
    }
}
