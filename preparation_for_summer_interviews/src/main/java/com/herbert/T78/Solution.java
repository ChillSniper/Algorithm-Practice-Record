package com.herbert.T78;

import java.util.ArrayList;
import java.util.List;

class Solution {
    
    private List<List<Integer>> ans;
    
    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        List<Integer> record = new ArrayList<>();
        dfs(nums, 0, record);
        return ans;
    }

    private void dfs(int[] nums, int index, List<Integer> record) {
        int n = nums.length;
        if (index >= n) {
            ans.add(new ArrayList<>(record));
            return ;
        }
        record.add(nums[index]);
        dfs(nums, index + 1, record);
        int sz = record.size();
        record.remove(sz - 1);
        dfs(nums, index + 1, record);
    }
}