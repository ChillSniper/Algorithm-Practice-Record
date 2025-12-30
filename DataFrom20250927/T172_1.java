import java.util.HashSet;
import java.util.Set;

public class T172_1 {
    public int minOperations(int[] nums) {
        int n = nums.length;
        Set<Integer> record = new HashSet<>();
        int[] f = new int[n + 1];
        for (int i = n - 1;i >= 0;i --) {
            int x = nums[i];
            if (record.contains(x)) {
                f[i] = 1;
            } else {
                f[i] = f[i + 1] == 1 ? 1 : 0;
                record.add(x);
            }
        }
        int cnt = 0, st = 0;
        
        while (st < n) {
            if (f[st] == 0)
                return cnt;
            st += 3;
            ++ cnt;
        }
        return cnt;
    }
}
