package com.bytedance;

public class T53 {
    public int maxSubArray(int[] nums) {
        int maxval = -100000;
        int n = nums.length;
        int cur = 0;
        for (int i = 0;i < n;i ++) {
            int x = nums[i];
            if (cur + x < x) {
                cur = x;
            } else {
                cur += x;
            }
            maxval = Math.max(maxval, cur);
        }
        return maxval;
    }
}
