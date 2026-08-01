package com.bytedance;

import java.util.ArrayList;
import java.util.List;

public class LongestSequence {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0;i < n;i ++) {
            int x = nums[i];
            int index = func(list, x);
            int sz = list.size();
            if (index >= sz) {
                list.add(x);
            } else {
                list.set(index, x);
            }
        }

        return list.size();
    }
    private int func(List<Integer> list, int val) {
        int sz = list.size();
        if (sz == 0) 
            return sz;
        int l = 0, r = sz - 1;
        while (l <= r) {
            int mid = ((r - l) >> 1) + l;
            // first >= val;
            if (list.get(mid) >= val) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
