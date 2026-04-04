package com.herbert.T1;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        int n = nums.length;
        Map<Integer, Integer> record = new HashMap<>();
        for (int i = 0;i < n;i ++) {
            int x = nums[i];
            if (record.containsKey(target - x)) {
                ans[0] = record.get(target - x);
                ans[1] = i;
                return ans;
            }
            if (!record.containsKey(x)) {
                record.put(x, i);
            }
        }
        return new int[]{};
    }
}
