public class T2141 {
    public long maxRunTime(int n, int[] batteries) {
        // 这个题目，做法一是采用贪心算法 + 构造算法去解决的方式
        // 这个构造方法压根想不出来，至少我现在是想不出来的
        // 但是还是需要将其看懂
        long sum = 0;
        for (int x : batteries) 
            sum += x;
        long l = 0, r = sum / n;
        while (l <= r) {
            long mid = (l + r) >> 1;
            long all = 0;
            for (int x : batteries) {
                all += Math.min(x, mid);
            }
            if (mid * n <= all) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }
}
