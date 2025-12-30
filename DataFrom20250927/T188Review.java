import java.util.*;

public class T188Review {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][k + 2][2];
        for (int[][] mat : dp) {
            for (int[] x : mat) {
                Arrays.fill(x, Integer.MIN_VALUE / 2);
            }
        }
        for (int j = 0;j <= k;j ++) {
            dp[0][j + 1][0] = 0;
        }
        for (int i = 0;i < n;i ++) {
            for (int j = 0;j <= k;j ++) {
                int x = prices[i];
                dp[i + 1][j + 1][0] = Math.max(dp[i][j + 1][0], dp[i][j][1] + x);
                dp[i + 1][j + 1][1] = Math.max(dp[i][j + 1][1], dp[i][j + 1][0] - x);
            }
        }
        return dp[n][k + 1][0];
    }
}
