public class T309dp {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        dp[0][1] = Integer.MIN_VALUE;
        for (int i = 0;i < n;i ++) {
            dp[i + 1][0] = Math.max(dp[i][0], dp[i][1] + prices[i]);
            dp[i + 1][1] = i >= 1 ? Math.max(dp[i][1], dp[i - 1][0] - prices[i]) : - prices[0];
        }   
        return dp[n][0];
    }
}

