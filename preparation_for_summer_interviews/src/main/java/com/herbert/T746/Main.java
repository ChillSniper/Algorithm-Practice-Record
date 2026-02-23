package com.herbert.T746;

public class Main {
    public int minCostClimbingStairs(int[] cost) {
        /*
        这题的出题人真是傻逼，不写人话的题面，我操你妈
        */
        int n = cost.length;
        int[] dp = new int[n + 1];
        // if (n <= 2)
        //     return 0;
        dp[n - 1] = cost[n - 1];
        for (int i = n - 2; i >= 0;i --) {
            dp[i] = Math.min(dp[i + 1], dp[i + 2]) + cost[i];
        }
        return Math.min(dp[0], dp[1]);
    }
}
