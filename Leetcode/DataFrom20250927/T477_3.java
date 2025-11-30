import java.util.*;

public class T477_3 {
    public int[] sumAndMultiply(String s, int[][] queries) {
        // 从后往前加
        
        final int MOD = (int)1e9 + 7;
        int n = s.length();
        int[] sumval = new int[n + 1], mulval = new int[n + 1];
        List<Integer> record = new ArrayList<>(); 
        mulval[0] = -1;
        for (int i = 0;i < n;i ++) {
            int ch = s.charAt(i) - '0';
            sumval[i + 1] = sumval[i] + ch;
            if (ch != 0) {
                record.add(ch);
            } 
            mulval[i + 1] = record.size() - 1;
        }   
        int sz = queries.length;
        int[] ans = new int[sz];



        for (int i = 0;i < sz;i ++) {
            int l = queries[i][0], r = queries[i][1];
            int s_val = (int) (sumval[r + 1] - sumval[l]) % MOD;
            int st = mulval[l], end = mulval[r + 1];
            long t = 0, p = 1;
            for (int j = end;j >= end - 10 + 1 && j > st && j >= 0;j --) {
                t += p * record.get(j);
                p *= 10;
            }
            t %= MOD;
            ans[i] = (int)(t * (long)s_val) % MOD;
        }
        return ans;
    }
    
}
