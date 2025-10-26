import java.util.*;

public class T473_2 {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        for (int i = 0;i < n;i ++) {
            nums[i] = nums[i] >= 0 ? nums[i] : -nums[i];
        }   
        Arrays.sort(nums);
        long ans = 0;
        int i;
        for (i = 0;i < n / 2;i ++) {
            long x = nums[i];
            ans -= x * x;
        }
        if (n % 2 == 1) {
            long x = nums[i ++];
            ans += x * x;
        }
        for (;i < n;i ++) {
            long x = nums[i];
            ans += x * x;
        }
        return ans;
    }
}
