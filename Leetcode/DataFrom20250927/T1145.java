public class T1145 {
    public int longestCommonSubsequence(String text1, String text2) {
        int lx = text1.length(), ly = text2.length();
        int[][] dp = new int[lx + 1][ly + 1];
        for (int i = 0;i < lx;i ++) {
            for (int j = 0;j < ly;j ++) {
                char x = text1.charAt(i);
                char y = text2.charAt(j);
                dp[i + 1][j + 1] = x == y ? dp[i][j] + 1 : Math.max(dp[i][j + 1], dp[i + 1][j]);
            }
        }
        return dp[lx][ly];
    }
}