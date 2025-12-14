import java.util.*;

public class T3766 {
    final int N = (int)1e5 + 10;
    private List<Integer> Fit;
    public int[] minOperations(int[] nums) {
        // 25 * 1e6 or 2.5 * 1e7
        Fit = new ArrayList<>();
        for (int i = 0;i < N;i ++) {
            if (isFit(i)) {
                Fit.add(i);
            }
        }
        int n = nums.length;
        for (int i = 0;i < n;i ++) {
            int val = getAns(nums[i]);
            nums[i] = Math.abs(nums[i] - val);
        }
        return nums;

    }
    private boolean isFit(int x) {
        List<Integer> record = new ArrayList<>();
        while (x > 0) {
            int p = x % 2;
            x /= 2;
            record.add(p);
        }
        int sz = record.size();
        for (int i = 0, j = sz - 1;i < j;i ++, j --) {
            if (Integer.compare(record.get(i), record.get(j)) != 0)
                return false;
        }
        return true;
    }
    private int getAns(int x) {
        int lval = left(x), rval = right(x);
        // return Math.min(x - lval, rval - x);
        if (x - lval < rval - x)
            return lval;
        return rval;
    }
    private int left(int x) {
        int n = Fit.size(), l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            int val = Fit.get(mid);
            if (val > x) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        // l = r = 7 fit return r
        // l = r = 7 not fit 
        return Fit.get(r);
    }
    private int right(int x) {
        int n = Fit.size(), l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            int val = Fit.get(mid);
            if (val < x) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        // l = r = 3 fit l
        return Fit.get(l);
    }
}
