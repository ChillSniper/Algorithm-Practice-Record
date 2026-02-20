package com.herbert.T416;

public class DpWay {
    public boolean canPartition(int[] nums) {
        int all = 0;
        for (int x : nums)
            all += x;
        if (all % 2 == 1)
            return false;
        all /= 2;
        int n = nums.length;
        boolean f[][] = new boolean[n + 1][all + 1];
        // pay attention to the init step
        f[0][0] = true;
        for (int i = 0; i < n;i ++) {
            for (int j = 0;j <= all;j ++) {
                int x = nums[i];
                f[i + 1][j] = j >= x && f[i][j - x] || f[i][j];
            }
        }
        return f[n][all];
    }
}
