import java.util.*;

public class T169_3 {
    public int longestSubarray(int[] nums) {
        // 首先没什么好说的，先对每个递增区间计算
        // 造成各个分离递增区间的原因是什么？是因为有离群点
        // 那就把离群点放到该放的位置上去
        // 我们替换一个值能做到什么？能够可能将两个区间合并到一块去
        // 当然不可能把三个区间合并到一块去，那就扯淡了

        List<int[]> record = new ArrayList<>();
        int n = nums.length;
        for (int i = 0;i < n;i ++) {
            int j = i;
            while (j + 1 < n && nums[j + 1] >= nums[j]) {
                ++ j;
            }
            record.add(new int[]{i, j});
            i = j;
        }
        n = record.size();
        if (n == 1) {
            return record.get(0)[1] - record.get(0)[0];
        }
        int ans = 0;
        for (int i = 1;i < n;i ++) {
            int bf_st = record.get(i - 1)[0], bf_lst = record.get(i - 1)[1];
            int nx_st = record.get(i)[0], nx_lst = record.get(i)[1];
            // int bf_st_val = nums[bf_st], bf_lst_val = nums[bf_lst];
            // int nx_st_val = nums[nx_st], nx_lst_val = nums[nx_lst];
            int bf_len = bf_lst - bf_st + 1;
            int nx_len = nx_lst - nx_st + 1;
            ans = Math.max(ans, bf_len);
            ans = Math.max(ans, nx_len);
            if (bf_len > 1 && nums[bf_lst - 1] <= nums[nx_st]) {
                ans = Math.max(ans, bf_len + nx_len);
            } else {
                ans = Math.max(ans, nx_len + 1);
            }
            if (nx_len > 1 && nums[nx_st + 1] >= nums[bf_lst]) {
                ans = Math.max(ans, bf_len + nx_len);
            } else {
                ans = Math.max(ans, bf_len + 1);
            }
        }
        return ans;
    }
}
