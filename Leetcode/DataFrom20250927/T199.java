
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class T199 {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> dq = new ArrayDeque<>();

        if (root == null) {
            return ans;
        }
        dq.addLast(root);
        while (!dq.isEmpty()) {
            int sz = dq.size();
            for (int i = 0; i < sz - 1; i++) {
                TreeNode t = dq.pollFirst();
                if (t.left != null) {
                    dq.addLast(t.left);
                }
                if (t.right != null) {
                    dq.addLast(t.right);
                }
            }
            TreeNode t = dq.pollFirst();
            ans.add(t.val);
            if (t.left != null) {
                dq.addLast(t.left);
            }
            if (t.right != null) {
                dq.addLast(t.right);
            }
        }
        return ans;
    }
}
