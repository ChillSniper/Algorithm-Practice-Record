package com.herbert.MS0804;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        if (n == 0) 
            return ans;
        Arrays.sort(nums);
        List<Integer> tmp = new ArrayList<>();
        dfs(tmp, nums, 0);
        return ans;
    }
    private void dfs(List<Integer> tmp, int[] nums, int index) {
        int n = nums.length;
        if (index == n) {
            ans.add(List.copyOf(tmp));
            return ;
        }
        tmp.add(nums[index]);
        dfs(tmp, nums, index + 1);
        // tmp.removeLast();
        int sz = tmp.size();
        tmp.remove(sz - 1);
        dfs(tmp, nums, index + 1);
    }
}