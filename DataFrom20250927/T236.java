public class T236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 这个类型的题有专门对应的算法，好像是叫LCA吗，不记得了
        // 做法估计是通过递归调用进行处理，但是怎么搞呢？
        // 沟槽的，一点头绪没有，如果打个暴力是很轻松的事，但是那样一点意义没有
        // 也就是说，这题可以转变为，求两个链表的最初交点
        // 困得一批，我需要睡觉
        // 的确，这题涉及到最近公共祖先的处理
        // 我看懂他那个解法了，这两个b节点要么在两边，要么都在一边，要么他妈的根节点本身就是
        if (root == null || root == p || root == q)
            return root;
        TreeNode lx = lowestCommonAncestor(root.left, p, q);
        TreeNode rx = lowestCommonAncestor(root.right, p, q);
        if (lx != null && rx != null)
            return root;
        return lx != null ? lx : rx;
    }
}
