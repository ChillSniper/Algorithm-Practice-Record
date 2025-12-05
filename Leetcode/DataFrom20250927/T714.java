
import java.util.Arrays;

public class T714 {
    private int[][] memo;
    private int fee;
    private int[] prices;
    public int maxProfit(int[] prices, int fee) {
        this.fee = fee;
        this.prices = prices;
        int n = prices.length;
        int[][] memo = new int[n][2];
        for (int[] row : memo) 
            Arrays.fill(row, -1);
        this.memo = memo;
        return dfs(n - 1, 0);
    }
    private int dfs(int i, int c) {
        if (i < 0) {
            return c == 1 ? Integer.MIN_VALUE / 2 : 0;
        }
        if (memo[i][c] != -1)
            return memo[i][c];
        if (c == 0) {
            return memo[i][c] = Math.max(dfs(i - 1, c), dfs(i - 1, 1) + prices[i] - fee);
        }
        return memo[i][c] = Math.max(dfs(i - 1, c), dfs(i - 1, 0) - prices[i]);
    }
}