package com.herbert.T482;

public class Q1 {
    public long maximumScore(int[] nums) {
        int n = nums.length;
        long[] pre = new long[n + 1];
        for (int i = 0;i < n;i ++) {
            pre[i + 1] = pre[i] + nums[i];
        }
        int[] minval = new int[n + 1];
        minval[n] = Integer.MAX_VALUE;
        for (int i = n - 1;i >= 0;i --) {
            minval[i] = Math.min(minval[i + 1], nums[i]);
        }
        long ans = pre[1] - minval[1];
        for (int i = 1;i < n - 1;i ++) {
            long x = pre[i + 1] - minval[i + 1];
            ans = Math.max(ans, x);
        }
        return ans;
    }
}
