public class T1526 {
    public int minNumberOperations(int[] target) {
        // 这个题有点眼熟，但是一时间想不起来是什么类型
        // 这个无非是贪心或者dp，但是如何处理
        // 我们可以从左往右，对每个val进行处理统计
        // 还是不会，留到下午写
        int n = target.length;
        int ans = target[0];
        for (int i = 1;i < n;i ++) {
            if (target[i] <= target[i - 1]) 
                ;
            else 
                ans += (target[i] - target[i - 1]);
        }
        return ans;
    }
}
