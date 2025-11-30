import java.util.*;

public class T637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.add(root);
        while (!dq.isEmpty()) {
            int sz = dq.size();
            double s = 0;
            for (int i = 0;i < sz;i ++) {
                TreeNode t = dq.pollFirst();
                if (t.left != null)
                    dq.addLast(t.left);                
                if (t.right != null)
                    dq.addLast(t.right);
                s += t.val;
            }
            ans.add(s / sz);
        }
        return ans;
    }
}