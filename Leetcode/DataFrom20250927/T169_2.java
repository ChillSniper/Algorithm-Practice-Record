public class T169_2 {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int[] cnt = new int[n + 1];
        for (int i = 0;i < n;i ++) {
            cnt[i + 1] = cnt[i - 1 + 1] + (nums[i] == target ? 1 : 0);
        }
        int ans = 0;
        for (int i = 0;i < n;i ++) {
            for (int j = i;j < n;j ++) {
                int x = cnt[j + 1] - cnt[i + 1 - 1];
                if (x > (j - i + 1) / 2) {
                    ++ ans;
                }
            }
        }
        return ans;
    }
}
