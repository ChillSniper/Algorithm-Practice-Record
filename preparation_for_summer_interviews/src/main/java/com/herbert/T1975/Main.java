package com.herbert.T1975;

public class Main {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        int cnt = 0, minval = Integer.MAX_VALUE;
        long sum = 0;
        for (int i = 0;i < n;i ++) {
            for (int j = 0;j < n;j ++) {
                int x = matrix[i][j];
                sum += Math.abs(x);
                minval = Math.min(minval, Math.abs(x));
                cnt += x < 0 ? 1 : 0;
            }
        }
        return (cnt % 2 == 0) ? sum : sum - 2 * minval;
    }
}
