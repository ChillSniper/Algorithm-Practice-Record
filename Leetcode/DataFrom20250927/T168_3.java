public class T168_3 {
    public long minOperations(int[] nums1, int[] nums2) {
        // 别急，这个题不是这么搞的
        int n = nums1.length;
        int val = nums2[n];
        long ans = 1;
        for (int i = 0;i < n;i ++) {
            ans += Math.abs(nums1[i] - nums2[i]);
        }
        long p = Long.MAX_VALUE;
        for (int i = 0;i < n;i ++) {
            int x = nums1[i], y = nums2[i];
            // if val [x, y] cost = 0
            // val < x <= y
            // x <= y < val
            // val < y < x
            // y < x < val
            long t = ans;
            if((val >= x && val <= y) || (val >= y && val <= x)) {
                t += 0;
            } else if(val < x && x <= y){
                t += 1 * (x - val);
            } else if(x <= y && y < val) {
                t += (val - y);
            } else if(val < y && y < x) {
                t += 1 * (y - val);
            } else if(y < x && x < val) {
                t += 1 * (val - x);
            }
            p = Math.min(p, t);
        }
        ans = p;
        return ans;
    }
}
