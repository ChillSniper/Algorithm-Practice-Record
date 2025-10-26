import java.util.*;

public class T473_4 {
    public long numGoodSubarrays(int[] nums, int k) {
        // 实际上，我们可以求和的时候不断mod k，这样比较容易计数
        // 但是这题的难点不在于计数，问题在于怎么去重
        // 我突然好像发现了一个可以利用的性质，这个数组是递增的！
        // 那么好像这题变得可做了
        // 当选取到一个新的val时，前面的val怎么取，都不是重复的，因为前面的val统计的长度是不一致的！
        // 当然前面的val也可以不选，这样的话，新的val的cnt取决于有多少个新增的ans
        // 最后把新的val先后加到前缀统计的Map中去！
        long cur = 0, ans = 0;
        Map<Integer, Integer> cnt = new HashMap<>();   
        int n = nums.length;
        // cnt.merge(0, 1, Integer::sum);
        for (int i = 0;i < n;i ++) {
            int j = i, val = nums[i];
            while (j < n && nums[j] == val) {
                ++ j;
            }
            // [i, j)
            long t = 0;
            for (int index = i;index < j;index ++) {
                t = (t + val) % k;
                int target = (k - (int)t) % k;
                ans += cnt.getOrDefault(target, 0);
                
            }
            for (int index = i;index < j;index ++) {
                cur = (cur + val) % k;
                cnt.merge((int)cur, 1, Integer::sum);
            }
            i = j - 1;
        }
        return ans;
    }
}
