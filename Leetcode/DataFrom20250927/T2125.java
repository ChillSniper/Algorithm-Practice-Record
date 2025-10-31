import java.util.*;

public class T2125 {
    public int numberOfBeams(String[] bank) {
        int n = bank.length, ans = 0;
        List<Integer> record = new ArrayList<>();
        for (int i = 0;i < n;i ++) {
            int cnt = 0;
            char[] ch = bank[i].toCharArray();
            for (char x : ch) {
                if (x == '1')
                    ++ cnt;
            }
            if (cnt != 0)
                record.add(cnt);
        }
        int len = record.size();
        for (int i = 1;i < len;i ++) {
            ans += record.get(i - 1) * record.get(i);
        }
        return ans;
    }
}
