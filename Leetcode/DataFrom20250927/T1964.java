
import java.util.*;

public class T1964 {

    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        // 这题原来是这个意思，维护的是最长非降子序列
        // 并且的，要理解到，是基于维护的g[]递增数组上进行操作！
        int n = obstacles.length;
        int[] ans = new int[n];
        List<Integer> g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = obstacles[i];
            int index = upper_bound(g, x);
            int sz = g.size();
            if (index >= sz) {
                g.add(x);
            } else {
                g.set(index, x);
            }
            ans[i] = index + 1;
        }
        return ans;
    }

    private int upper_bound(List<Integer> nums, int target) {
        int n = nums.size(), l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (nums.get(mid) <= target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
