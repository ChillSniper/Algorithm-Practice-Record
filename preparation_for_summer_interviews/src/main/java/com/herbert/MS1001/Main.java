package com.herbert.MS1001;

public class Main {
    public void merge(int[] A, int m, int[] B, int n) {
        // swap ai, bj
        
        // md我发现这个我不会做

        // 牛魔这个得想到从后往前遍历，而不是硬是想着从前往后遍历，不然根本整不出来
        int lst = m + n - 1, i = m - 1, j = n - 1, cur;
        while (i > -1 || j > -1) {
            if (i < 0) {
                cur = B[j --];
            } else if (j < 0) {
                cur = A[i --];
            } else {
                if (A[i] < B[j]) {
                    cur = B[j --];
                } else {
                    cur = A[i --];
                }
            }
            A[lst --] = cur;
        }
    }
}
