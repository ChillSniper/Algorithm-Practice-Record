public class T1027 {
    private final int MAXNUM = 500;
    public int longestArithSeqLength(int[] nums) {
        // 的确有一个暴力做法
        // 对于每一个当前的元素i，我们记录...
        // 也就是说，可以开一个dp[n + 1][MAXNUM + 1]
        int n = nums.length, ans = 1;
        int[][] dp = new int[n + 10][MAXNUM * 2 + 10];
        for (int i = 0;i < n;i ++) {
            for (int j = -500;j <= 500;j ++)
                dp[i + 1][j + MAXNUM] = 1;
            
            for (int j = 0;j < i;j ++) {
                int absval = nums[j] - nums[i];
                absval += MAXNUM;
                dp[i + 1][absval] = Math.max(dp[i + 1][absval], dp[j + 1][absval] + 1);
                ans = Math.max(ans, dp[i + 1][absval]);
            }
            dp[i + 1][0 + MAXNUM] = Math.max(dp[i + 1][0 + MAXNUM], 1);
            ans = Math.max(ans, dp[i + 1][0 + MAXNUM]);
        }
        return ans;

    }
}
