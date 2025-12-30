public class T714dp {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        dp[0][1] = Integer.MIN_VALUE / 2;
        for (int i = 0;i < n;i ++) {
            
            dp[i + 1][0] = Math.max(dp[i][0], dp[i][1] + prices[i] - fee);
            dp[i + 1][1] = Math.max(dp[i][1], dp[i][0] - prices[i]);
        }
        return dp[n][0];
    }
}
