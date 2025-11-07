public class T2257 {
    private final int G = 1;
    private final int Wall = 2;
    private final int prtc = 3;
    
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        // 这个题有点像爆搜
    
        int[][] grid = new int[m][n];
        for (int[] x : guards) {
            int i = x[0], j = x[1];
            grid[i][j] = G;
        }
        for (int[] x : walls) {
            int i = x[0], j = x[1];
            grid[i][j] = Wall;
        }

        for (int i = 0;i < m;i ++) {
            for (int j = 0;j < n;j ++) {
                if (grid[i][j] == G) {
                    op(m, n, grid, i, j);
                }
            }
        }
        int cnt = 0;
        for (int i = 0;i < m;i ++) {
            for (int j = 0;j < n;j ++) {
                if (grid[i][j] == 0)
                    ++ cnt;
            }
        }
        return cnt;
    }
    private void op (int m, int n, int[][] gird, int i, int j) {
        for (int st = j - 1;st >= 0;-- st) {
            if (gird[i][st] == 0 || gird[i][st] == prtc) 
                gird[i][st] = prtc;
            else break;
        }
        for (int st = j + 1;st < n;++ st) {
            if (gird[i][st] == 0 || gird[i][st] == prtc) 
                gird[i][st] = prtc;
            else break;
        }
        for (int st = i - 1;st >= 0;-- st) {
            if (gird[st][j] == 0 || gird[st][j] == prtc) {
                gird[st][j] = prtc;
            }
            else break;
        }
        for (int st = i + 1;st < m;++ st) {
            if (gird[st][j] == 0 || gird[st][j] == prtc) {
                gird[st][j] = prtc;
            }
            else break;
        }
    }
}
