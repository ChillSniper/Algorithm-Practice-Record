package com.herbert.MS0105;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        String first = "ab", second = "bc";
        s.oneEditAway(first, second);
    }
    public boolean oneEditAway(String first, String second) {
        // 这个应该是动态规划
        // 但不知道该怎么做
        int n = first.length(), m = second.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0;i < n;i ++) {
            dp[i + 1][0] = i + 1;
        }
        for (int j = 0;j < m;j ++) 
            dp[0][j + 1] = j + 1;
        for (int i = 0;i < n;i ++) {
            for (int j = 0;j < m;j ++) {
                char x = first.charAt(i), y = second.charAt(j);
                if (x == y) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    dp[i + 1][j + 1] = Math.min(dp[i][j] + 1, Math.min(dp[i][j + 1] + 1, dp[i + 1][j] + 1));
                }

            }
        }
        return dp[n][m] <= 1;
    }
}
