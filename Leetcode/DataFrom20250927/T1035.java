public class T1035 {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int lx = nums1.length, ly = nums2.length;
        int[][] dp = new int[lx + 1][ly + 1];
        for (int i = 0;i < lx;i ++) {
            for (int j = 0;j < ly;j ++) {
                if (nums1[i] == nums2[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        return dp[lx][ly];
    }
}
