import java.util.Arrays;

public class T122New {
    private int[] prices;
    private int[][] memo;
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
    private int dfs(int i, int condition) {
        if (i < 0) {
            return condition == 0 ? 0 : Integer.MIN_VALUE;
        }
        if (memo[i][condition] != -1) {
            return memo[i][condition];
        }
        if (condition == 0) {
            return memo[i][condition] = Math.max(dfs(i - 1, 0), dfs(i - 1, 1) + prices[i]);
        }
        return memo[i][condition] = Math.max(dfs(i - 1, 1), dfs(i - 1, 0) - prices[i]);
    }
}
