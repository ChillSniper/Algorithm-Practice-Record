package com.herbert.T122;

public class Solution {
    public int maxProfit(int[] prices) {
        // 我也不知道一开始脑子里在想什么，写了个莫名其妙的东西出来
        // int n = prices.length;
        // int[][] dp = new int[n + 1][2];
        // int ans = 0;
        // for (int i = 0;i < n;i ++)  {
        //     int val = prices[i];
        //     for (int j = 0;j <= i;j ++) {
        //         dp[i + 1][0] = Math.max(dp[i + 1][0], dp[j][1] - val);
        //         dp[i + 1][1] = Math.max(dp[i + 1][1], dp[j][0] + val);
        //         ans = Math.max(ans, dp[i + 1][1]);
        //     }
        // }

        // return ans;

        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        dp[0][1] = Integer.MIN_VALUE;
        for (int i = 0;i < n;i ++) {
            dp[i + 1][0] = Math.max(dp[i][0], dp[i][1] + prices[i]);
            dp[i + 1][1] = Math.max(dp[i][1], dp[i][0] - prices[i]);
        }

        // 这边核心是要理解dp[i][j]中的那个j，指的是手里有几只股票

        return dp[n][0];
    }
}
