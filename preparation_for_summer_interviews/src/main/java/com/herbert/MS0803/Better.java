package com.herbert.MS0803;

public class Better {
    public int findMagicIndex(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i ++) {
            nums[i] -= i;
        }
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            int val = nums[mid];
            if (val > 0) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }
}
