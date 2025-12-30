import java.util.ArrayList;
import java.util.List;

public class T113 {
    final private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> t = new ArrayList<>();
        dfs(root, targetSum, t);
        return ans;
    }

    private void dfs(TreeNode root, int curLeft, List<Integer> t) {
        if (root == null)
            return ;
        int sz = t.size();
        t.add(root.val);
        if (root.left == null && root.right == null) {
            if (root.val == curLeft) {
                ans.add(new ArrayList<>(t));
            }
            
            // t.remove();
            // return ;
        }
        
        dfs(root.left, curLeft - root.val, t);
        dfs(root.right, curLeft - root.val, t);
        t.remove(sz);   
    }
}
