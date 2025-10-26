import java.util.HashMap;
import java.util.Map;

public class T974 {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> cnt = new HashMap<>();
        int cur = 0, ans = 0;
        cnt.merge(cur, 1, Integer::sum);
        for (int x : nums) {
            // 这个真的坑比，这边有负数
            cur = (cur + x + k * 5000) % k;
            ans += cnt.getOrDefault(cur, 0);
            cnt.merge(cur, 1, Integer::sum);
        }
        return ans;
    }
}