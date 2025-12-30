package com.herbert.T213;

public class Main {
    public int rob(int[] nums) {
        int n = nums.length, ans;
        // if get 0, then [2, n - 2]
        // else [1, n - 1]
        ans = Math.max(nums[0] + func(nums, 2, n - 2), func(nums, 1, n - 1));
        return ans;   
    }
    private int func(int[] nums, int l, int r) {
        // [l, r]
        int pre2 = 0, pre1 = 0, cur, ans = 0;
        for (int i = l;i <= r;i ++) {
            cur = Math.max(pre1, pre2 + nums[i]);
            ans = Math.max(ans, cur);
            pre2 = pre1;
            pre1 = cur;
        }
        return ans;
    }
}
