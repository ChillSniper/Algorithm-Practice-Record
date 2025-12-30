package com.herbert.T3781;

import java.util.PriorityQueue;

public class Main {
    public long maximumScore(int[] nums, String s) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return b - a;
        });
        int n = nums.length;
        long ans = 0;
        for (int i = 0;i < n;i ++) {
            char ch = s.charAt(i);
            pq.add(nums[i]);
            if (ch == '1') {
                ans += pq.poll();
            }
        }
        return ans;
    }
}
