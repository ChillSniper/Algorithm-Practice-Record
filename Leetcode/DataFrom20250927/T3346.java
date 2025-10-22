import java.util.*;

public class T3346 {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        // 排序的念头有过那么一刹那
        // 刚刚自己好像是想出来了，就是一些细节没有处理好
        // 我们的目的是，先排序，然后对每个数字进行维护，二分处理
        // 最终确定ans
        Arrays.sort(nums);
        int ans = 0;
        int[] cnt = new int[(int)1e5 + 10], vis = new int[(int)1e5 + 10];
        for (int val : nums)
            ++ cnt[val];
        
        for (int val = nums[0];val <= nums[nums.length - 1];++ val) {
            if(vis[val] == 1)
                continue;
            vis[val] = 1;
            int lw = val - k, hi = val + k;
            // then we find what ? 
            // we should find index >= lw and index >= (hi + 1)
            // then sub it
            int l = LowerBound(nums, lw), r = LowerBound(nums, hi + 1);
            ans = Math.max(ans, Math.min(numOperations, r - l - cnt[val]) + cnt[val]);
        }
        return ans;
    }
    private int LowerBound(int[] nums, int val) {
        int n = nums.length, l = 0, r = n - 1;
        while(l <= r) {
            int mid = (l + r) >> 1;
            if(nums[mid] < val) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
