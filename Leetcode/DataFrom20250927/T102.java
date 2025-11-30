import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class T102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)   
            return ans;
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.add(root);
        while (!dq.isEmpty()) {
            int sz = dq.size();
            List<Integer> t = new ArrayList<>();
            for (int i = 0;i < sz;i ++) {
                TreeNode l = dq.pollFirst();
                t.add(l.val);
                if (l.left != null) {
                    dq.addLast(l.left);
                }
                if (l.right != null) {
                    dq.addLast(l.right);
                }
            }
            ans.add(t);
        }
        return ans;
    }
}
