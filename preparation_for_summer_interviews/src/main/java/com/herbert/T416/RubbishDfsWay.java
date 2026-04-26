package com.herbert.T416;

/*
* author: HerbertLu
* note: 有一段时间没写这个了，结果刚刚自己想了半天，写了这么一坨答辩出来。。。所以算法还是需要及时复习
*/

public class RubbishDfsWay {
    public boolean canPartition(int[] nums) {
        int s = 0;
        for (int x : nums) 
            s += x;
        
        if (s % 2 == 1)
            return false;
        // md这个怎么做的来着，现在完全忘了……
        // 草了，这个怎么做的，全忘了……
        // 再思考一下，这个如何利用当前的cur来计算呢？
        
        
        int target = s / 2;
        boolean[] flag = new boolean[target + 1];
        int[] vis = new int[target + 1];

        return dfs(nums, 0, target, flag, vis);
    }

    private boolean dfs(int[] nums, int index, int cur, boolean[] flag, int[] vis) {
        int n = nums.length;
        if (index >= n) {
            return cur == 0;
        }
        if (cur == 0)
            return true;
        if (vis[cur] == 1)
            return flag[cur];
        vis[cur] = 1;
        int x = nums[index];
        if (cur - x >= 0 && vis[cur - x] == 1)
            return flag[cur - x];
        if (cur - x < 0) {
            flag[cur] = false;
            vis[cur] = 1;
            return flag[cur];
        }
        flag[cur - x] = dfs(nums, index + 1, cur - x, flag, vis);
        flag[cur] = flag[cur] | flag[cur - x];
        return flag[cur];
    }
}
