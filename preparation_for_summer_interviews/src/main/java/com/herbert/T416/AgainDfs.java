package com.herbert.T416;

import java.util.Arrays;

class AgainDfs {
    public boolean canPartition(int[] nums) {
        int s = 0;
        for (int x : nums) 
            s += x;
        
        if (s % 2 == 1)
            return false;
        // md这个怎么做的来着，现在完全忘了……
        // 草了，这个怎么做的，全忘了……
        // 再思考一下，这个如何利用当前的cur来计算呢？
        int target = s / 2;
        int n = nums.length;
        int[][] memo = new int[n][target + 1];
        for (int[] x : memo) {
            Arrays.fill(x, -1);
        }

        return dfs(nums, target, n - 1, memo);
    }

    private boolean dfs(int[] nums, int cur, int index, int[][] memo) {
        if (index < 0) {
            return cur == 0;
        }
        if (cur <= 0)
            return cur == 0;
        if (memo[index][cur] != -1) {
            return memo[index][cur] == 0;
        }
        memo[index][cur] = (dfs(nums, cur - nums[index], index - 1, memo) || dfs(nums, cur, index - 1, memo)) ? 0 : 1;
        return memo[index][cur] == 0;
    }
}