package com.herbert.T198;

public class Main {
    public int rob(int[] nums) {
        int ans = 0, n = nums.length;
        int[] dp = new int[n + 2];
        for (int i = 0;i < n;i ++) {
            dp[i + 2] = Math.max(dp[i] + nums[i], dp[i + 1]);
            ans = Math.max(ans, dp[i + 2]);
        }   
        return ans;
    }
}
