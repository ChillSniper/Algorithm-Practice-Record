import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T46 {
    
    private List<List<Integer>> ans;
    
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        int n = nums.length;
        List<Integer> path = Arrays.asList(new Integer[n]);
        boolean[] onPath = new boolean[n];
        dfs(0, onPath, nums, path);
        return ans;
    }
    private void dfs(int i, boolean[] onPath, int[] nums, List<Integer> path) {
        int n = nums.length;
        if (i == n) {
            ans.add(new ArrayList<>(path));
            return ;
        }
        for (int j = 0;j < n;j ++) {
            if (onPath[j] == false) {
                onPath[j] = true;
                path.set(i, nums[j]);
                dfs(i + 1, onPath, nums, path);
                onPath[j] = true;
            }
        }
    }
}
