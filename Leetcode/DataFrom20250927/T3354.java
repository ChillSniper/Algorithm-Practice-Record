import java.util.*;

public class T3354 {
    public int countValidSelections(int[] nums) {
        // 这什么鸟题目
        // O(n * 2 * n * 2)
        int n = nums.length, ans = 0;
        for (int i = 0;i < n;i ++) {
            if (nums[i] != 0)
                continue;
            int[] t = Arrays.copyOf(nums, n);
            ans += check(i, -1, n, t) ? 1 : 0;
            t = Arrays.copyOf(nums, n);
            ans += check(i, 1, n, t) ? 1 : 0;
        }
        return ans;
    }
    private Boolean check(int index, int dir, int n, int[] nums) {
        if(index < 0 || index >= n) {
            for (int i = 0;i < n;i ++) {
                if (nums[i] != 0)
                    return false;
            }
            return true;
        }
        if (nums[index] == 0) {
            return check(index + dir, dir, n, nums);
        }
        nums[index] -= 1;
        dir = -dir;
        return check(index + dir, dir, n, nums);
    }
}