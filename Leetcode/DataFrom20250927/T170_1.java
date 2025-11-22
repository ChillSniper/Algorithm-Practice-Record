import java.util.ArrayList;
import java.util.List;

public class T170_1 {
    public int minimumFlips(int n) {
        List<Integer> record = new ArrayList<>();
        while (n > 0) {
            int x = n % 2;
            record.add(x);
            n /= 2;       
        }
        int sz = record.size();
        int cnt = 0;
        for (int i = 0, j = sz - 1;i < j;i ++, j --) {
            cnt += (record.get(i) == record.get(j)) ? 0 : 2;
        }
        return cnt;
    }
}