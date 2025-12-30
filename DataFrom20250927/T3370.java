
public class T3370 {
    public int smallestNumber(int n) {
        // 这个题目条件没有太看懂什么意思
        // 5 = 101
        // I know what means
        // all 1
        // 2 ^ t - 1
        int ans = 0, p = 1;
        while (n > 0) {
            ans += p;
            p <<= 1;
            n >>= 1;
        }
        return ans;
    }
}
