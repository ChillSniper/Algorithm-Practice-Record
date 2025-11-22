
import java.util.*;

public class T354 {

    public int maxEnvelopes(int[][] envelopes) {
        // 这个题的思路肯定是先去排序
        // 数据范围决定了算法应当是nlogn的，甚至可能是n
        // 并且的，这个dp是二维的
        // 思路是什么呢？对于当前这个信封，其所寻找到的应当是符合要求的比其小的信封，然后计算max值
        // 草，看了一下评论区大概有思路了
        // 很显然要使用二分算法，但是对于如果长度相同，高度不一致的信封应当如何处理呢？这是解答本题的关键
        // 但是问题来了，如果保留高度高的那个，后面的塞不下怎么办？
        // 如果保留高度低的那个，塞不下前面的又怎么办？

        // 看了一下题解，这题的思路是真的妙，巧妙的转换为了LIS问题，nice
        // 可惜自己没想出来，但是现在得记住这个思路，一会回去把它写掉
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        int n = envelopes.length;
        int[] t = new int[n];
        for (int i = 0; i < n; i++) {
            t[i] = envelopes[i][1];
        }
        return LIS(t);
    }

    private int LIS(int[] nums) {
        int n = nums.length;
        List<Integer> g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            int index = lower_bound(g, x);
            int sz = g.size();
            if (index < sz) {
                g.set(index, x);
            } else {
                g.add(x);
            }
        }
        return g.size();
    }

    private int lower_bound(List<Integer> nums, int target) {
        int n = nums.size(), l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (nums.get(mid) < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
