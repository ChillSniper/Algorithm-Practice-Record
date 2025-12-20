
import java.util.Arrays;

public class T3573 {
    public long maximumProfit(int[] prices, int k) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][k + 2][2];
        for (int[][] mat : dp) {
            for (int[] x : mat) {
                Arrays.fill(x, Integer.MIN_VALUE / 2);
            }
        }
        for (int i = 0;i <= k;i ++)
            dp[0][i + 1][0] = 0;
        
        for (int i = 0;i < n;i ++) {
            int x = prices[i];
            for (int j = 0;j <= k;j ++) {
                dp[i + 1][j + 1][0] = Math.max(dp[i][j + 1][0], dp[i][j][1] + x);
                dp[i + 1][j + 1][1] = Math.max(dp[i][j + 1][1], dp[i][j][0] - x);
            }    
        }
        return dp[n][k + 1][0];
    }
}