import java.util.*;

public class Test1 {
    public int BinarySearch(int[] nums, int target) {
        int n = nums.length, l = 0, r = n - 1;
        while (l <= r) {
            int mid = l + ((r - 1) >> 1);
            if (nums[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        // long nums[], target max, 
        return r;
    }
    private List<Integer> record;
    public int kInTree(TreeNode root, int k) {
        this.record = new ArrayList<>();
        Get(root);
        int n = record.size();
        return record.get(n - k);
    }
    private void Get(TreeNode root) {
        if (root == null)
            return ;
        Get(root.left);
        record.add(root.val);
        Get(root.right);
    }
}
