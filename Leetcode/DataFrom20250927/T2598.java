import java.util.*;

public class T2598 {
    public int findSmallestInteger(int[] nums, int value) {
        Map<Integer, Integer> record = new HashMap<>();
        for (int x : nums) {
            int t = (x % value + value) % value;
            record.merge(t, 1, Integer::sum);
        }
        int st = 0;
        while(true) {
            int p = st % value;
            if(record.containsKey(p)) {
                ++ st;
                record.merge(p, -1, Integer::sum);
                if(record.get(p) == 0)
                    record.remove(p);
            } else {
                return st;
            }
        }
    }
}
