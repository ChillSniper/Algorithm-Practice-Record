package com.herbert.T5;

class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n <= 1)
            return s;
        int ans = 1, bg = 0;
        boolean[][] dp = new boolean[n][n];
        for (int i = 0;i < n;i ++) {
            dp[i][i] = true;
        }
        for (int Len = 2;Len < n;++ Len) {
            for (int i = 0;i < n;i ++) {
                int j = i + Len - 1;
                if (j >= n)
                    continue;
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;

                } else {
                    if (Len <= 3)
                        dp[i][j] = true;
                    else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                    if (dp[i][j] && Len > ans) {
                        ans = Len;
                        bg = i;
                    }
                }
            }
        }
        return s.substring(bg, ans);
    }
}