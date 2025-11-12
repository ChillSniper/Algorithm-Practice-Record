import java.util.*;

public class T124 {
    
    private Map<TreeNode, Integer> record;

    private int ans;

    public int maxPathSum(TreeNode root) {
        // 这题坑人的地方主要在于有负数节点
        // 怎么思考呢？
        // 对于每个节点，三个方向的路中要选择两条
        // 有个问题，这最大路径不到叶子结点怎么办
        // 这个破题我大概知道怎么搞了，先自底向上过一遍，记录一下它往下走的最大值是多少
        // 然后再自顶向下走一遍，确定最大路径和
        record = new HashMap<>();
        dfs(root);
        ans = Integer.MIN_VALUE;
        up_to_down(root, 0);
        return ans;
    }
    private void up_to_down(TreeNode root, int x) {
        if (root == null)
            return ;
        int t = record.getOrDefault(root, 0);
        t = Math.max(t, t + x);
        ans = Math.max(ans, t);
        int next_val = Math.max(x + root.val, root.val);
        up_to_down(root.left, next_val);
        up_to_down(root.right, next_val);
    }
    private int dfs(TreeNode root) {
        if (root == null)
            return 0;
        int l = dfs(root.left);
        int r = dfs(root.right);
        ans = Math.max(ans, root.val + l + r);
        int x = Math.max(root.val + 0, root.val + l);
        x = Math.max(x, root.val + r);
        ans = Math.max(ans, x);
        record.put(root, x);
        return x;
    }
}
