import java.util.*;

public class T171_3 {
    public long maxPoints(int[] technique1, int[] technique2, int k) {
        long ans = 0;
        int n = technique1.length;
        int[][] record = new int[n][3];
        for (int i = 0;i < n;i ++) {
            record[i][0] = technique1[i];
            record[i][1] = technique2[i];
            record[i][2] = technique1[i] - technique2[i];
        }  
        Arrays.sort(record, (a, b) -> {
            return b[2] - a[2];
        });
        for (int i = 0;i < k;i ++) {
            ans += record[i][0];
        }
        for (int i = k;i < n;i ++) {
            ans += Math.max(record[i][0], record[i][1]);
        }
        return ans;
    }
}
