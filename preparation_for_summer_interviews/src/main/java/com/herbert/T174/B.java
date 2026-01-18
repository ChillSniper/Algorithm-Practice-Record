package com.herbert.T174;

import java.util.HashSet;
import java.util.Set;

public class B {
    public int minOperations(int[] nums, int[] target) {
        int cnt = 0, n = nums.length;
        Set<Integer> r = new HashSet<>();
        for (int i = 0;i < n;i ++) {
            if (nums[i] != target[i] && !r.contains(nums[i])) {
                r.add(nums[i]);
                ++ cnt;
            }
        }
        return cnt;
    }

}
