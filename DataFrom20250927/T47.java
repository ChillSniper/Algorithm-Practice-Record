import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T47 {
    private List<List<Integer>> ans;
    public List<List<Integer>> permuteUnique(int[] nums) {
        ans = new ArrayList<>();
        int n = nums.length;
        List<Integer> path = Arrays.asList(new Integer[n]);
        boolean[] onPath = new boolean[n];
        dfs(0, path, onPath, nums);
        return ans;
    }

    private void dfs(int i, List<Integer> path, boolean[] onPath, int[] nums) {
        int n = nums.length;
        if (i == n) {
            ans.add(new ArrayList<>(path));
        }
        int[] record = new int[30];
        for (int j = 0;j < n;j ++) {
            if (onPath[j] == false && record[nums[j] + 10] == 0) {
                record[nums[j] + 10] = 1;
                onPath[j] = true;
                path.set(i, nums[j]);
                dfs(i + 1, path, onPath, nums);
                onPath[j] = false;
            }
        }
    }
}
