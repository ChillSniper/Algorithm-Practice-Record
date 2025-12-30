import java.util.*;

public class T106 {

    private Map<Integer, Integer> record;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // 又是这种……
        record = new HashMap<>();  
        int n = postorder.length;
        for (int i = 0;i < n;i ++) {
            record.put(inorder[i], i);
        }
        return dfs(inorder, 0, n - 1, postorder, 0, n - 1);
    }
    private TreeNode dfs(int[] in, int in_st, int in_lst, int[] post, int post_st, int post_lst) {
        int len = in_lst - in_st + 1;
        if (len <= 0)
            return null;
        int val = post[post_lst];
        TreeNode root = new TreeNode(val);
        int index = record.get(val);
        int lf_len = index - 1 - in_st + 1;
        int ri_len = in_lst - (index + 1) + 1;
        root.left = dfs(in, in_st, in_st + lf_len - 1, post, post_st, post_st + lf_len - 1);
        root.right = dfs(in, index + 1, index + 1 + ri_len - 1, post, post_st + lf_len, post_lst - 1);
        return root;
    }
}
