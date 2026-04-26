package com.herbert.T2078;

public class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int dis = 0;
        int i = 0, j = n - 1;
        while (j >= 0 && colors[j] == colors[0]) {
            -- j;
        }
        dis = Math.max(dis, j - i);
        i = 0;
        j = n - 1;
        while (i <= n - 1 && colors[i] == colors[n - 1]) {
            ++ i;
        }
        dis = Math.max(dis, j - i);

        return dis;
    }
}
