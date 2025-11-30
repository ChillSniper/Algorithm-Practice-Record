
import java.util.ArrayList;
import java.util.List;

public class T477_1 {
    public long sumAndMultiply(int n) {
        List<Integer> record = new ArrayList<>();   
        while (n > 0) {
            int x = n % 10;
            n /= 10;
            if (x != 0) {
                record.add(x);
            }
        }
        if (record.isEmpty())
            return 0;
        int k = 0, p = 1, s = 0, sz = record.size();
        for (int i = 0;i < sz;i ++) {
            k += record.get(i) * p;
            p *= 10;
            s += record.get(i);
        }
        return k * s;
    }
}