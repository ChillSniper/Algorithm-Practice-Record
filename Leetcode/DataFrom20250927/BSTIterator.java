import java.util.*;

public class BSTIterator {

    Deque<TreeNode> dq;

    public BSTIterator(TreeNode root) {
        // 我看懂这个要搞什么了，这个就是二叉遍历搜索树，进行中根遍历
        // 但是现在的问题是，怎么执行二叉搜索树的遍历流程呢？
        // 最无脑的办法是，执行一遍中序遍历，然后用数组记录下来，但是这样不是乱套了么
        // 卧槽，我想起来了，这个是BST，也就是说，这个二叉树中的元素是有序的！
        // 题解已看懂，这个东西总感觉什么时候好像写过，但已经完全不记得了
        // 同时，这题和BST没有任何关系，换成普通二叉树也可以搞
        // 之所以空间复杂度是O(logn)，因为始终只有左节点入栈，这样的话相当于为logn高度的节点入栈
        // 因为这个是中根遍历啊！所以要对每个节点的右节点接着做向左到底的处理
        dq = new ArrayDeque<>();
        while (root != null) {
            dq.addLast(root);
            root = root.left;
        }
    }
    
    public int next() {
        int val = dq.getLast().val;
        TreeNode root = dq.pollLast();
        root = root.right;
        while (root != null) {
            dq.addLast(root);
            root = root.left;
        }
        return val;
  }
    
    public boolean hasNext() {
        return !dq.isEmpty();
    }
}