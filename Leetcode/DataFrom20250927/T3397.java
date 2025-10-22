import java.util.Arrays;

public class T3397 {
    public int maxDistinctElements(int[] nums, int k) {
        // 怎么一点头绪没有
        // 这个当然是先sort一下
        Arrays.sort(nums);
        int Lf = Integer.MIN_VALUE, cnt = 0, n = nums.length;
        for (int i = 0;i < n;i ++) {
            int val = nums[i], l = val - k, r = val + k;
            if(l > Lf) {
                Lf = l;
                ++ cnt;
                continue;
            }
            if(r <= Lf) {
                continue;
            }
            Lf ++;
            ++ cnt;
        }
        return cnt;
    }
}