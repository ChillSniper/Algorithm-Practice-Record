package com.herbert.MS0108;

public class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] row = new int[m], col = new int[n];
        for (int i = 0;i < m;i ++){
            for (int j = 0;j < n;j ++) {
                if (matrix[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
        for (int i = 0;i < m;i ++) {
            for (int j = 0;j < n;j ++) {
                if (row[i] == 1 || col[j] == 1) {
                    matrix[i][j] = 0;
                }
           }
        }
    }
}
