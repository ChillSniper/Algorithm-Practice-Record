import java.util.*;

public class T480 {
    TreeMap<Integer, Integer> maxHeap, minHeap;
    int l_size = 0, r_size = 0;
    public double[] medianSlidingWindow(int[] nums, int k) {
        // 为啥我总觉得这题好像在哪见过
        // 这个东西怎么remove掉，
        // 使用PriorityQueue是不明智的，得用TreeMap...
        // 但是使用TreeMap带来了一个新的问题，如果我要在两个map之间移动元素，
        // 这涉及到cnt的计数，以及对重复元素的处理
        // len of ans = n - k + 1
        int n = nums.length;
        double[] ans = new double[n - k + 1];
        maxHeap = new TreeMap<>();
        minHeap = new TreeMap<>();
        for (int i = 0;i < k;i ++) {
            int x = nums[i];
            add(x);
        }
        ans[0] = get();
        for (int i = k;i < n;i ++) {
            remove(nums[i - k]);
            add(nums[i]);
            ans[i - k + 1] = get();
        }
        return ans;
    }
    private void add(int x) {
        // int l_size = maxHeap.size(), r_size = minHeap.size();
        if (l_size == r_size) {
            // 先加到左边那个去
            maxHeap.merge(x, 1, Integer::sum);
            int val = maxHeap.lastKey();
            maxHeap.merge(val, -1, Integer::sum);
            if (maxHeap.get(val) == 0)
                maxHeap.remove(val);

            minHeap.merge(val, 1, Integer::sum);
            ++ r_size;
        } else {
            minHeap.merge(x, 1, Integer::sum);
            int val = minHeap.firstKey();
            minHeap.merge(val, -1, Integer::sum);
            if (minHeap.get(val) == 0) 
                minHeap.remove(val);
            
            maxHeap.merge(val, 1, Integer::sum);
            ++ l_size;
        }
    }
    private void remove(int x) {
        // 这个需求真的一坨
        if (minHeap.containsKey(x)) {
            minHeap.merge(x, -1, Integer::sum);
            if (minHeap.get(x) == 0)
                minHeap.remove(x);
            -- r_size;
        } else {
            maxHeap.merge(x, -1, Integer::sum);
            if (maxHeap.get(x) == 0) 
                maxHeap.remove(x);
            -- l_size;
        }
        // int l_size = maxHeap.size(), r_size = minHeap.size();
        // n n + 1
        // -> n- 1 n + 1
        // -> n n
        // n n
        // n- 1 n
        // n n -1
        if (l_size + 2 == r_size) {
            int val = minHeap.firstKey();
            minHeap.merge(val, -1, Integer::sum);

            if (minHeap.get(val) == 0)
                minHeap.remove(val);
            
            maxHeap.merge(val, 1, Integer::sum);
            -- r_size;
            ++ l_size;
        } else if(l_size == r_size + 1) {
            int val = maxHeap.lastKey();
            maxHeap.merge(val, -1, Integer::sum);
            if (maxHeap.get(val) == 0)
                maxHeap.remove(val);
            minHeap.merge(val, 1, Integer::sum);
            -- l_size;
            ++ r_size;
        }
    }
    private double get() {
        // int l_size = maxHeap.size(), r_size = minHeap.size();
        if (l_size + 1 == r_size) {
            return minHeap.firstKey();
        } else {
            return (long)((long)maxHeap.lastKey() + (long)minHeap.firstKey()) / 2.0;
        }
    }
}
