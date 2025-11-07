import java.util.HashMap;
import java.util.Map;

public class T105 {

    private Map<Integer, Integer> record;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        record = new HashMap<>();
        int n = inorder.length;
        for (int i = 0;i < n;i ++) {
            record.put(inorder[i], i);
        }
        return dfs(preorder, inorder, 0, n - 1, 0, n - 1);
    }
    private TreeNode dfs(int[] pre, int[] in, int p_l, int p_r, int i_l, int i_r) {
        if (p_l > p_r) {
            return null;
        }
        int val = pre[p_l];
        int index = record.get(val);
        int left_len = index - i_l;
        // int right_len = i_r - index;
        // [p_l + 1, p_l + left_len]
        // [p_l + left_len + 1, p_r]
        TreeNode root = new TreeNode(val);
        root.left = dfs(pre, in, p_l + 1, p_l + left_len, i_l, index - 1);
        root.right = dfs(pre, in, p_l + left_len + 1, p_r, index + 1, i_r);
        return root;
    }
}
