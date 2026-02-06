package com.herbert.MS0802;

import java.util.ArrayList;
import java.util.List;

public class DfsWay {
    private List<List<Integer>> ans;
    final private int[][] dir = new int[][]{{1, 0}, {0, 1}};
    final private int DirNum = 2;
    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        ans = new ArrayList<>();
        int n = obstacleGrid.length;
        if (n == 0 || obstacleGrid[0].length < 1 || obstacleGrid[0][0] == 1)
            return ans;

        int m = obstacleGrid[0].length;
        int[][] vis = new int[n][m];
        vis[0][0] = 1;
        ans.add(List.of(0, 0));
        boolean flag = dfs(0, 0, vis, obstacleGrid);
        if (flag) {
            return ans;
        }
        return new ArrayList<>();
    }

    private boolean dfs(int x, int y, int[][] vis, int[][]obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        if (x == n - 1 && y == m - 1) {

            return true;
        }
        for (int i = 0;i < DirNum;i ++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            if (nx > -1 && nx < n && ny > -1 && ny < m && vis[nx][ny] == 0 && obstacleGrid[nx][ny] == 0) {
                vis[nx][ny] = 1;
                ans.add(List.of(nx, ny));
                boolean flag = dfs(nx, ny, vis, obstacleGrid);
                if (!flag) {
                    int sz = ans.size();
                    ans.remove(sz - 1);
                } else {
                    return true;
                }
            }
        }
        return false;
    }
}
