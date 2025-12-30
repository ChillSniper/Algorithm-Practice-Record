import java.util.*;

public class T3347 {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        // 这题二分的解法被卡了，得用新的做法
        Map<Integer, Integer> cnt = new HashMap<>();
        Map<Integer, Integer> diff = new TreeMap<>();
        for (int item : nums) {
            cnt.merge(item, 1, Integer::sum);
            diff.putIfAbsent(item, 0);
            diff.merge(item - k, 1, Integer::sum);
            diff.merge(item + k + 1, -1, Integer::sum);
        }
        int ans = 0;
        int cur = 0;
        for (Map.Entry<Integer, Integer> en : diff.entrySet()) {
            int key = en.getKey();
            int val = en.getValue();
            cur += val;
            ans = Math.max(ans, Math.min(numOperations + cnt.getOrDefault(key, 0), cur));
            // if not exist
            // = min(numOp + 0, cur);
            // else
            //  = min(numop, cur - cnt[i]) + cnt[i]; it's equal to min(numop + cnt[i], cur)
        }
        return ans;
    }
}