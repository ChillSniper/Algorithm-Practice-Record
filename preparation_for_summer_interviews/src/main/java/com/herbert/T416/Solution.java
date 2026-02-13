package com.herbert.T416;

import java.util.Arrays;

/*
this method using dfs, written on 2026.02.13
*/

class Solution {
    public boolean canPartition(int[] nums) {
        int s = 0, n = nums.length;
        for (int i = 0;i < n;i ++) {
            s += nums[i];
        }
        if (s % 2 == 1) 
            return false;
        int[][] memo = new int[n][s / 2 + 1];
        for (int[] x : memo) {
            Arrays.fill(x, -1);
        }
        return Dfs(nums, memo, s / 2, n - 1);
    }
    private boolean Dfs(int[] nums, int[][] memo, int left, int index) {
        if (index < 0) {
            return left == 0;
        }
        if (left < 0)
            return false;
        if (memo[index][left] != -1) {
            return memo[index][left] == 1;
        }
        memo[index][left] = Dfs(nums, memo, left - nums[index], index - 1) || Dfs(nums, memo, left, index - 1) ? 1 : 0;
        return memo[index][left] == 1;
    }
}