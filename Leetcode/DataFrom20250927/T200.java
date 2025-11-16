import java.util.*;

public class T200 {

    private int[][] dir;

    public int numIslands(char[][] grid) {
        dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int cnt = 0;
        int m = grid.length, n = grid[0].length;
        int[][] vis = new int[m][n];
        for (int i = 0;i < m;i ++) {
            for (int j = 0;j < n;j ++) {
                if (grid[i][j] == '0' || vis[i][j] == 1) {
                    vis[i][j] = 1;
                    continue;
                }
                ++ cnt;
                bfs(grid, vis, i, j);
            }
        }
        return cnt;
    }
    private void bfs(char[][] grid, int[][] vis, int i, int j) {
        if (vis[i][j] == 1 || grid[i][j] == '0')
            return ;
        int m = grid.length, n = grid[0].length;
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{i, j});
        while (!dq.isEmpty()) {
            int[] t = dq.pollFirst();
            int x = t[0], y = t[1];
            if (vis[x][y] == 1 || grid[x][y] == '0') {
                continue;
            }
            vis[x][y] = 1;
            for (int index = 0;index < 4;index ++) {
                int nx = x + dir[index][0];
                int ny = y + dir[index][1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }
                if (grid[nx][ny] == '0' || vis[nx][ny] == 1) {
                    continue;
                }
                dq.add(new int[]{nx, ny});
            }
        }
    }
}
