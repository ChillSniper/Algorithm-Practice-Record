public class T222 {
    public int countNodes(TreeNode root) {
        // 数学计数法
        // 别着急，慢慢算
        // 事实证明这个题没有数学公式直接计算方法，而是应当采用类二分查找+递归的思想去解决
        if (root == null)
            return 0;
        int l = getLevel(root.left), r = getLevel(root.right);
        if (l == r) {
            return (1 << l) + countNodes(root.right);
        } else {
            return (1 << r) + countNodes(root.left);
        }
    }
    private int getLevel(TreeNode root) {
        int h = 0;
        while (root != null) {
            root = root.left;
            ++ h;
        }
        return h;
    }
}
