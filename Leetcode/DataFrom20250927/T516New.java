public class T516New {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0;i < n;i ++) {
            dp[i][i] = 1;
        }   
        char[] ch = s.toCharArray();
        int ans = 1;
        for (int len = 2;len <= n;len ++) {
            for (int i = 0;i + len - 1 < n;i ++) {
                dp[i][i + len - 1] = ch[i] == ch[i + len - 1] ? dp[i + 1][i + len - 2] + 2 : Math.max(dp[i][i + len - 2], dp[i + 1][i + len - 1]);
                ans = Math.max(ans, dp[i][i + len - 1]);
            }
        }
        return ans;
    }
}