import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class T103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // i thought the result should be this
        // 3
        // 9 20
        // 15 7
        int f = 1;
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.add(root);
        while (!dq.isEmpty()) {
            List<Integer> t = new ArrayList<>();
            int sz = dq.size();
            for (int i = 0;i < sz;i ++) {
                TreeNode node = new TreeNode(-1);
                if (f == 1) {
                    node = dq.pollFirst();
                } else if(f == -1)
                    node = dq.pollLast();
                t.add(node.val);
                if (f == 1) {
                    if (node.left != null) {
                        dq.addLast(node.left);
                    }
                    if (node.right != null) {
                        dq.addLast(node.right);
                    }
                } else {
                    if (node.left != null) {
                        dq.addFirst(node.right);
                    }
                    if (node.right != null) {
                        dq.addFirst(node.left);
                    }
                }
            }
            ans.add(t);
            f *= -1;
        }
        return ans;
    }
}
