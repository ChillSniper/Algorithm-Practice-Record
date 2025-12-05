import java.util.Arrays;

public class T3623 {
    public int countTrapezoids(int[][] points) {
        // n * (n - 1) / 2;
        long ans = 0;
        final long MOD = (int)1e9 + 7;
        Arrays.sort(points, (x, y) -> {
            if (x[1] == y[1])
                return x[0] - y[0];
            return x[1] - y[1];
        });
        long tot = 0;
        int n = points.length;
        for (int i = 0;i < n;i ++) {
            int cur_y = points[i][1], j = i + 1, real_cnt = 1;
            while (j < n && points[j][1] == cur_y) {
                if (points[j][0] != points[j - 1][0]) {
                    ++ real_cnt;
                }
                ++ j;
            }
            i = j - 1;
            long cur = (real_cnt) * (real_cnt - 1) / 2 % MOD;
            ans = (ans + cur * tot % MOD) % MOD;
            tot = (cur + tot) % MOD;
        }
        return (int)ans;
    }
}
