public class T170_3 {
    public int[] lexSmallestNegatedPerm(int n, long target) {
        // sum = (1 + n) * n / 2
        // sigma val = target
        // target + sum = 2 * (sigma (each val > 0))
        long s = (1 + n) * n / 2;   
        if ((target < 0 && target < (-s)) || (target > 0 && target > s))
            return new int[]{};
        long t = s + target;
        if (t % 2 == 1)
            return new int[]{};
        long graterZero = t / 2;
        long lessZero = s - graterZero;
        int[] erase = new int[n + 1];
        for (int i = n;i >= 1;i --) {
            if (i <= lessZero) {
                erase[i] = 1;
                lessZero -= i;
            }
            if (lessZero == 0)
                break;
        }
        int[] ans = new int[n];
        int index = 0;
        for (int i = n;i >= 1;i --) {
            if (erase[i] == 1)
                ans[index ++] = - i;
        }
        for (int i = 1;i <= n;i ++) {
            if (erase[i] == 0) {
                ans[index ++] = i; 
            }
        }
        return ans;
    }
    private boolean judge(int[] x, int[] y) {
        int n = x.length;
        for (int i = 0;i < n;i ++) {
            if (x[i] < y[i])
                return true;
            else if(x[i] > y[i])
                return false;
        }
        return true;
    }
}
