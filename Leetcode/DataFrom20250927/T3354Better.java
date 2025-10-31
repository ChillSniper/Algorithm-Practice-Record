public class T3354Better {
    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int[] Pre = new int[n + 1], Suf = new int[n + 1];
        for (int i = 0;i < n;i ++) {
            Pre[i + 1] = nums[i] + Pre[i];
        }   
        for (int i = n - 1;i >= 0;i --) {
            Suf[i] = Suf[i + 1] + nums[i];
        }
        int ans = 0;
        for (int i = 0;i < n;i ++) {
            if (nums[i] != 0)
                continue;
            if(Pre[i] == Suf[i + 1])
                ans += 2;
            else if (Math.abs(Pre[i] - Suf[i + 1]) == 1)
                ans += 1;
        }
        return ans;
    }
}
