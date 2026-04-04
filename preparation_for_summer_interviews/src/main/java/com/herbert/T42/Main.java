package com.herbert.T42;

public class Main {
    public int trap(int[] height) {
        int n = height.length;
        int[] lf = new int[n], rf = new int[n];
        for (int i = 1;i < n;i ++) {
            lf[i] = Math.max(lf[i - 1], height[i + 1]);
        }
        for (int i = n - 2;i > -1;i --) {
            rf[i] = Math.max(rf[i + 1], height[i + 1]);
        }
        int ans = 0;
        for (int i = 0;i < n;i ++) {
            int mx = Math.min(lf[i], rf[i]);
            ans += height[i] <= mx ? mx - height[i] : 0;
        }
        return ans;
    }
}
