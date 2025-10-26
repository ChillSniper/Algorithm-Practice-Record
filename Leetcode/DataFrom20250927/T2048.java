public class T2048 {
    public int nextBeautifulNumber(int n) {
        while (true) {
            ++ n;
            if (check(n))
                return n;
        }
    }
    private boolean check(int x) {
        int[] r = new int[10];
        while(x > 0) {
            int t = x % 10;
            x /= 10;
            r[t] ++;
        }
        if(r[0] != 0)
            return false;
        for (int i = 0;i < 10;i ++) {
            if (r[i] != i && r[i] != 0)
                return false;
        }
        return true;
    }
}