public class T122 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int lw = prices[0], ans = 0;
        for (int i = 1;i < n;i ++) {
            if (prices[i] <= lw)
                lw = prices[i];
            else {
                ans += (prices[i] - lw);
                lw = prices[i];
            }
        }
        return ans;
    }
}
