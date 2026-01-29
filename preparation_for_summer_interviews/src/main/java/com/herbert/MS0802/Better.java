package com.herbert.MS0802;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Better {
    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        List<List<Integer>> ans = new ArrayList<>();
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return ans;
        }
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0;i < m;i ++) {
            for (int j = 0;j < n;j ++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                } 
                if ((i - 1 >= 0 && dp[i - 1][j] == 1) || (j - 1 >= 0 && dp[i][j - 1] >= 0)) {
                    dp[i][j] = 1;
                }
            }
        }
        int curx = m - 1, cury = n - 1;
        while (curx >= 0 && cury >= 0) {
            if (dp[curx][cury] == 0) {
                break;
            }
            ans.add(List.of(curx, cury));
            if (curx - 1 >= 0 && dp[curx - 1][cury] == 1) {
                -- curx;
                continue;
            }
            if (cury - 1 >= 0 && dp[curx][cury - 1] == 1) {
                -- cury;
                continue;
            }
            break;
        }
        Collections.reverse(ans);
        if (ans.get(0).get(0) == 0 && ans.get(0).get(1) == 0)
            return ans;
        return new ArrayList<>();
    }
}
