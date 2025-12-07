import java.util.*;
public class T479_1 {
    public int[] sortByReflection(int[] nums) {
        int n = nums.length;
        int[][] record = new int[n][2];
        for (int i = 0;i < n;i ++) {
            record[i][0] = nums[i];
            record[i][1] = op(nums[i]);
        }
        Arrays.sort(record, (a, b) -> {
            if (a[1] == b[1])
                return a[0] - b[0];
            return a[1] - b[1];
        });
        for (int i = 0;i < n;i ++)
            nums[i] = record[i][0];
        return nums;
    }
    private int op(int x) {
        int s = 0;
        while (x > 0) {
            int p = x % 2;
            x /= 2;
            s = s * 2 + p;
        }
        return s;
    }
}
