package com.herbert.T236;
import com.herbert.Utils.TreeNode;

public class Twice {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;
        TreeNode lans = lowestCommonAncestor(root.left, p, q);
        TreeNode rans = lowestCommonAncestor(root.right, p, q);
        if (lans != null && rans != null)
            return root;   
        return lans != null ? lans : rans;
    }
}
