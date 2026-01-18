package com.herbert.MS0108;

public class Better {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int frow = 0, fcol = 0;
        for (int i = 0;i < m;i ++) {
            if (matrix[i][0] == 0) {
                frow = 1;
                break;
            }
        }
        for (int j = 0;j < n;j ++) {
            if (matrix[0][j] == 0) {
                fcol = 1;
                break;
            }
        }
        for (int i = 1;i < m;i ++) {
            for (int j = 1;j < n;j ++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1;i < m;i ++) {
            for (int j = 1;j < n;j ++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (frow == 1) {
            for (int i = 0;i < m;i ++) {
                matrix[i][0] = 0;
            }
        }
        if (fcol == 1) {
            for (int j = 0;j < n;j ++) {
                matrix[0][j] = 0;
            }
        }
    }
}
