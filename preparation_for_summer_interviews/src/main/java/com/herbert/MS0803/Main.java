package com.herbert.MS0803;

class Main {
    public int findMagicIndex(int[] nums) {
        int n = nums.length;
        for (int i = 0;i < n;i ++) {
            if (nums[i] == i) {
                return i;
            }
        }
        return -1;
    }
}