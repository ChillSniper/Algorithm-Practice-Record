package com.herbert.T121;

public class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0, n = prices.length;
        int minVal = Integer.MAX_VALUE / 2;
        for (int i = 0;i < n;i ++) {
            int p = prices[i];
            if (p < minVal) {
                minVal = p;
            } else {
                ans = Math.max(ans, p - minVal);
            }
        }
        return ans;
    }
}
