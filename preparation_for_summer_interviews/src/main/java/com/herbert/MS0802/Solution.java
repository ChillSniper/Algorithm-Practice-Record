package com.herbert.MS0802;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int [][]t = new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        List<List<Integer>> ans = s.pathWithObstacles(t);
    }
    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        List<List<Integer>> ans = new ArrayList<>();
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        // how to record a path
        // it must be solved using dp, but how to record the path ?
        // choose one of the enabled path is accessible
        int[][] enable = new int[m][n];
        if (obstacleGrid[0][0] == 0) {
            enable[0][0] = 1;
        }
        for (int i = 0;i < m;i ++) {
            for (int j = 0;j < n;j ++) {
                if (obstacleGrid[i][j] == 1) {
                    continue;
                }
                boolean f = false;
                if (i - 1 >= 0 && enable[i - 1][j] == 1) {
                    f = true;
                }
                if (j - 1 >= 0 && enable[i][j - 1] == 1) {
                    f = true;
                }
                if (f) {
                    enable[i][j] = 1;
                }
            }
        }
        int curx = m - 1, cury = n - 1;
        while (true) {
            if (curx < 0 || cury < 0) {
                break;
            }
            if (enable[curx][cury] == 0) {
                break;
            }
            ans.add(Arrays.asList(curx, cury));
            if (curx - 1 >= 0 && enable[curx - 1][cury] == 1) {
                -- curx;
                continue;
            }
            if (cury - 1 >= 0 && enable[curx][cury - 1] == 1) {
                -- cury;
                continue;
            }
            break;

        }
        int sz = ans.size();
        for (int i = 0;i < sz;i ++) {
            System.out.println(ans.get(i).get(0) + " " + ans.get(i).get(1));
        }
        Collections.reverse(ans);
        if (sz == 0 || !(ans.get(0).get(0) == 0 && ans.get(0).get(1) == 0))
            return new ArrayList<>();
        return ans;
    }
}