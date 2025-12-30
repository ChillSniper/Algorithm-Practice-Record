public class T1094 {
    public boolean carPooling(int[][] trips, int capacity) {
        // 等一下，我似乎想起来了，差分的含义是对数值区间进行求导
        int[] f = new int[1010];
        int n = trips.length;
        for (int i = 0;i < n;i ++) {
            int val = trips[i][0], from = trips[i][1], to = trips[i][2];
            f[from + 1] += val;
            f[to + 1] -= val;
        }
        for (int i = 0;i <= 1000;i ++) {
            f[i + 1] += f[i];
            if(f[i + 1] > capacity)
                return false;
        }
        return true;
    }
}
