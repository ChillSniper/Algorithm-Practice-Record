package com.herbert.MS0803;

public class Better {
    public int findMagicIndex(int[] nums) {
        /*
        * 没有任何意义的一道题，使用动态规划也没用，因为那个数组根本没有性质；
        * 所以一次遍历过去直接完事
        */
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
