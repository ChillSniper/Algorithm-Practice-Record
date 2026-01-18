package com.herbert.T174;

class A {
    public int[] bestTower(int[][] towers, int[] center, int radius) {
        int[] ans = new int[]{-1, -1};
        int max_q = -1, lx = (int)1e6, ly = (int)1e6;
        for (int[] m : towers) {
            int x = m[0], y = m[1], q = m[2];
            int ms = Math.abs(x - center[0]) + Math.abs(y - center[1]);
            if (ms <= radius) {
                if (q > max_q) {
                    max_q = q;
                    lx = x;
                    ly = y;
                } else if(q == max_q) {
                    if (x < lx || (x == lx && y < ly)) {
                        lx = x;
                        ly = y;
                    }
                }
            }
        }
        if (max_q != -1) {
            ans[0] = lx;
            ans[1] = ly;
        }
        return ans;
    }    
}