public class T479_3 {
    public long totalScore(int hp, int[] damage, int[] requirement) {
        // 可以把之前的damage累加起来，然后二分找到值
        // 可以计算damage的后缀数组
        // 对于当前节点i，减去之后受到的所有伤害last
        // 也就是说，要加上这个last去后缀数组中0,i-1查找
        // hp - x >= re
        // x <= hp - re
        // find the val <= hp - re + last
        long ans = 0;
        int n = damage.length;
        long[] suf = new long[n + 1];
        for (int i = n - 1;i >= 0;i --) {
            suf[i] = suf[i + 1] + damage[i];
        }
        for (int i = 0;i < n;i ++) {
            long last = suf[i + 1];
            // if val > hp - re + last fail
            // lower_bound
            int index = f(suf, 0, i, hp - requirement[i] + last);
            // len = i - 1 - index
            ans += i - index;
        }
        return ans;
    }
    private int f(long[] nums, int l, int r, long target) {
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (nums[mid] <= target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        // first > target
        // target = 7 nusm = [7] l = 0, r = -1 return r;
        // target = 8 nums = [7] l = 0, r = -1 return r;
        // target = 6 nums = [7] l = 1, r = 0 return r;
        return r;
    }
}
