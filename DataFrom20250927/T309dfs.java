import java.util.*;

public class T309dfs {
    private int[][] memo;
    private int[] prices;
    public int maxProfit(int[] prices) {
        int n = prices.length;
        this.prices = prices;
        int[][] memo = new int[n][2];
        for (int[] x : memo) {
            Arrays.fill(x, -1);
        }
        this.memo = memo;
        return dfs(n - 1, 0);
    }
    private int dfs(int i, int c) {
        if (i < 0)
            return c == 0 ? 0 : Integer.MIN_VALUE / 2;
        if (memo[i][c] != -1)
            return memo[i][c];
        if (c == 0) 
            return memo[i][c] = Math.max(dfs(i - 1, c), dfs(i - 1, 1) + prices[i]);
        return memo[i][c] = Math.max(dfs(i - 1, c), dfs(i - 2, 0) - prices[i]);
    } 
}
