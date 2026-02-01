package com.herbert.ContestDoubleWeek175;

import java.util.Arrays;
import java.util.PriorityQueue;

public class T4 {
    public long minPartitionScore(int[] nums, int k) {
        // may be more balance more better
        PriorityQueue<Integer> t = new PriorityQueue<>((a, b) -> {return a - b;});
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = n - 1;i >= n - k;i --) {
            t.add(nums[i]);
        }
        for (int i = n - k - 1;i > -1;i --) {
            int x = t.poll();
            x += nums[i];
            t.add(x);
        }
        long ans = 0;
        while (!t.isEmpty()) {
            long p = t.poll();
            ans += (p + 1) * p / 2;
        }
        return ans;
    }
}