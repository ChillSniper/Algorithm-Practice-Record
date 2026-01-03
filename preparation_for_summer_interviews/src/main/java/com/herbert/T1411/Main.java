package com.herbert.T1411;

public class Main {

    final int MOD = (int)1e9 + 7;

    public int numOfWays(int n) {
        // 121
        // 123
        // 131
        // 132
        // cur_condition from All sigma of back legal condition !
        // then old_condition = new_condition
        int cnt = 0;
        // at last, return sigma of old condition
        //
        int[][][] old = new int[3][3][3], nw = new int[3][3][3];
        for (int i = 0;i < 3;i ++)
            for (int j = 0;j < 3;j ++)
                for (int k = 0;k < 3;k ++) 
                    if (rowJudge(i, j, k))
                        old[i][j][k] = 1;
        while (cnt < n - 1) {
            for (int i = 0;i < 3;i ++) {
                for (int j = 0;j < 3;j ++) {
                    for (int k = 0;k < 3;k ++) {
                        for (int yi = 0;yi < 3;yi ++) {
                            for (int yj = 0;yj < 3;yj ++) {
                                for (int yk = 0;yk < 3;yk ++) {
                                    if (col(i, j, k, yi, yj, yk))
                                        nw[yi][yj][yk] = (nw[yi][yj][yk] + old[i][j][k]) % MOD;
                                }
                            }
                        }
                    }
                }
            }
            ++ cnt;
            copy_new_to_old(old, nw);
        }
        // Todo:
        long ans = 0;
        for (int i = 0;i < 3;i ++) {
            for (int j = 0;j < 3;j ++) {
                for (int k = 0;k < 3;k ++) {
                    ans = (ans + old[i][j][k]) % MOD;
                    
                }
            }
        }
        return (int)ans;
    } 

    private boolean col(int xi, int xj, int xk, int yi, int yj, int yk) {
        if (yi == yj || yj == yk) 
            return false;
        if (xi == yi || xj == yj || xk == yk)
            return false;
        return true;
    }

    private boolean rowJudge(int i, int j, int k) {
        if (i == j || j == k)
            return false;
        return true;
    }
    private void copy_new_to_old(int[][][] old, int[][][] nw) {
        for (int i = 0;i < 3;i ++) {
            for (int j = 0;j < 3;j ++) {
                for (int k = 0;k < 3;k ++) {
                    old[i][j][k] = nw[i][j][k];
                    nw[i][j][k] = 0;
                }
            }
        }
    }
}
