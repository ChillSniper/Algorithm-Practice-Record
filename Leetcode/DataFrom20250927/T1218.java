
public class T1218 {
    final private int ADD_VAL = (int)1e4;
    public int longestSubsequence(int[] arr, int difference) {
        // 这破题什么意思
        // 如果以当前元素为序列长度 那么反正新开一个
        // 不然的话接在之前的那段里面，这个也许可以维护一个map记录一下
        // 也就是说，我们可以维护记录到当前值的等差序列的最大值
        // Map<Integer, Integer> record = new HashMap<>();
        int[] record = new int[(int)3e4 + 10];

        int n = arr.length, ans = 0;
        for (int i = 0;i < n;i ++) {
            int val = arr[i], last_val = val - difference, t_len;
            t_len = record[last_val + ADD_VAL] + 1;
            record[val + ADD_VAL] = Math.max(record[val + ADD_VAL], t_len);
            
            ans = Math.max(ans, record[val + ADD_VAL]);
        }
        return ans;
    }
}
