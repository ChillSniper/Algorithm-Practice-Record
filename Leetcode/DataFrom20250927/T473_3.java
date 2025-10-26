import java.util.*;

public class T473_3 {
    public long countStableSubarrays(int[] capacity) {
        // 好像也不对啊，如果每个元素都相同，那么问题来了，n * n
        // 首先我们不难记录所有相同元素的集合
        // A a A b A c A
        // 上面这种考虑方式其实欠妥，不应当这么计算
        // 我们要计算的，是x - A的数量
        int n = capacity.length;
        long[] Pre = new long[n + 1];
        for (int i = 0;i < n;i ++) {
            Pre[i + 1] = Pre[i] + capacity[i];
        }
        Map<Integer, TreeSet<Integer>> map = new HashMap<>();
        for (int i = 0;i < n;i ++) {
            int x = capacity[i];
            map.computeIfAbsent(x, k -> new TreeSet<>()).add(i);
        }   
        long ans = 0;
        for (Map.Entry<Integer, TreeSet<Integer>> en : map.entrySet()) {
            Integer A = en.getKey();
            TreeSet<Integer> record = en.getValue();
            Map<Long, Integer> cnt = new HashMap<>();
            for (int index : record) {
                long t = Pre[index];
                ans += cnt.getOrDefault(t - A, 0);
                cnt.merge(t + A, 1, Integer::sum);
            }
        }
        // 把特殊情况减掉得了
        long w_s = 0;
        for (int i = 1;i < n;i ++) {
            if(capacity[i] == capacity[i - 1] && capacity[i] == 0) {
                w_s ++;
            }
        }
        ans -= w_s;
        return ans;
    }

}
