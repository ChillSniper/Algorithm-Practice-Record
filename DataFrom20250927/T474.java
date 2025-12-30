
public class T474 {
    public int findMaxForm(String[] strs, int m, int n) {
        // 这个应该是dp
        int[][] dp = new int[m + 1][n + 1];
        int len = strs.length;
        for (int i = 0;i < len;i ++) {
            char[] ch = strs[i].toCharArray();
            int cnt_0 = 0, cnt_1 = 0;
            for (char x : ch) {
                if (x == '0') 
                    ++ cnt_0;
                else 
                    ++ cnt_1;
            }
            if (cnt_0 <= m && cnt_1 <= n) {
                for (int j = m;j >= cnt_0;-- j)
                    for (int k = n;k >= cnt_1;-- k) {
                        dp[j][k] = Math.max(dp[j][k], dp[j - cnt_0][k - cnt_1] + 1);
                    }
            }
        }
        return dp[m][n];
    }
}
