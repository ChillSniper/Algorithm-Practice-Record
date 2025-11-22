import java.util.ArrayList;
import java.util.List;

public class T170_2 {
    public int totalWaviness(int num1, int num2) {
        int ans = 0;
        for (int i = num1;i <= num2;i ++)
            ans += get(i);
        return ans;
    }
    private int get(int x) {
        if (x < 100)
            return 0;
        List<Integer> record = new ArrayList<>();   
        while (x > 0) {
            int p = x % 10;
            x /= 10;
            record.add(p);
        }
        int sz = record.size();
        int ans = 0;
        for (int i = 1;i < sz - 1;i ++) {
            if (record.get(i) > record.get(i - 1) && record.get(i) > record.get(i + 1))
                ++ ans;
            if (record.get(i) < record.get(i - 1) && record.get(i) < record.get(i + 1))
                ++ ans;
            
        }
        return ans;
    }
}
