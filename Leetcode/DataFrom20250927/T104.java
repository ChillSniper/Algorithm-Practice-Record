
class T104 {
    int MaxDepth = 0;
    public int maxDepth(TreeNode root) {
       dfs(root, 0);
       return MaxDepth; 
    }  
    private void dfs(TreeNode cur, int d) {
        if (cur == null) {
            MaxDepth = Math.max(MaxDepth, d);
            return ;
        }
        dfs(cur.left, d + 1);
        dfs(cur.right, d + 1);
    }
}