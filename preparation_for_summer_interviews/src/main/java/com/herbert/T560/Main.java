package com.herbert.T560;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length, ans = 0;
        Map<Integer, Integer> r = new HashMap<>();
        r.put(0, 1);
        int cur = 0;
        for (int i = 0;i < n;i ++) {
            cur += nums[i];
            ans += r.getOrDefault(cur - k, 0);
            r.merge(cur, 1, Integer::sum);
        }
        return ans;
        // return -1;
    }
}
