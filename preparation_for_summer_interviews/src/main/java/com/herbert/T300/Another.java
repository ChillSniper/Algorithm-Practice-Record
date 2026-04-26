package com.herbert.T300;

import java.util.ArrayList;
import java.util.List;

public class Another {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        List<Integer> g = new ArrayList<>();

        for (int i = 0;i < n;i ++) {
            int val = nums[i];
            int index = lower_bound(g, val);
            if (index >= g.size()) {
                g.add(val);
            } else {
                g.set(index, val);
            }
        }
        return g.size();
    }

    private int lower_bound(List<Integer> g, int val) {
        int n = g.size();
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (g.get(mid) < val) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
