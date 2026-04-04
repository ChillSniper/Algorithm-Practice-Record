package com.herbert.T32;

class Solution {
    public int longestValidParentheses(String s) {
        String newStr = " " + s;
        int len = newStr.length();
        int[] dp = new int[len];
        char[] chStr = newStr.toCharArray();
        int ans = 0;
        for (int i = 1;i < len;i ++) {
            char ch = chStr[i];
            if (ch == '(') {
                dp[i] = 0;
            } else {
                // ch = ')'
                char bfch = chStr[i - 1];
                if (bfch == '(') {
                    dp[i] = dp[i - 2] + 2;
                } else if (bfch == ')'){
                    int index = i - 1 - dp[i - 1];
                    if (index <= 0 || chStr[index] == ')') {
                        dp[i] = 0;
                    } else {
                        dp[i] = dp[index - 1] + dp[i - 1] + 2;
                    }
                }
            }
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}