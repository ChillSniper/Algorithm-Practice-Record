public class T168_1 {
    public String lexSmallest(String s) {
        int n = s.length();
        String ans = s;
        for (int k = 1;k <= n;k ++) {
            char[] t = s.toCharArray();
            Reverse(t, 0, k);
            String nl = new String(t);
            if(nl.compareTo(ans) < 0)
                ans = nl;
            Reverse(t, 0, k);
            Reverse(t, n - k, n);
            nl = new String(t);
            if(nl.compareTo(ans) < 0)
                ans = nl;
        }   
        return ans;
    }
    private void Reverse(char[] t, int lf, int ri) {
        -- ri;
        while(lf < ri) {
            char ch_lf = t[lf];
            char ch_ri = t[ri];
            t[lf] = ch_ri;
            t[ri] = ch_lf;
            ++ lf;
            -- ri;
        }
    }
}
