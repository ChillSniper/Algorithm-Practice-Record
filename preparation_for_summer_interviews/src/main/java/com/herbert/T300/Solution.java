package com.herbert.T300;

class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int n = nums.length;
        int[] dp = new int[n + 1];
        int ans = 0;

        for (int i = 0;i < n;i ++) {
            dp[i + 1] = 1;
            for (int j = i - 1;j > -1;j --) {
                if (nums[i] > nums[j]) {
                    dp[i + 1] = Math.max(dp[i + 1], dp[j + 1] + 1);
                }
            }
            ans = Math.max(dp[i + 1], ans);
        }

        return ans;
    }

}