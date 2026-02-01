package com.herbert.ContestDoubleWeek175;

public class T2 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1};
        T2 t = new T2();
        int ans = t.minimumK(nums);
        System.out.println(ans);
    }
    public int minimumK(int[] nums) {
        int maxval = -1, n = nums.length;
        for (int i = 0;i < n;i ++) {
            maxval = Math.max(maxval, nums[i]);
        }   
        int l = 1, r = maxval * 2;
        while (l <= r) {
            int mid = (l + r) >> 1;
            boolean f = Enable(nums, mid);
            if (f) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
    private boolean Enable(int[] nums, int k) {
        int cnt = 0, n = nums.length;
        for (int i = 0;i < n;i ++) {
            cnt += nums[i] / k + (nums[i] % k == 0 ? 0 : 1);
        }
        return cnt <= (long)k * (long)k;
    }
}
