public class T2211 {
    public int countCollisions(String directions) {
        char[] s = directions.toCharArray();
        int n = s.length, ans = 0, pre_static = 0, pre_right = 0;
        for (int i = 0;i < n;i ++) {
            if (s[i] == 'S') {
                // static
                ans += pre_right;
                pre_static += 1;
                // pre_static += pre_right;
                pre_right = 0;

            } else if (s[i] == 'R') {
                // going right
                pre_right += 1;
            } else {
                // going left.
                if (pre_right > 0) {
                    ans += 2;
                    pre_right -= 1;
                    ans += pre_right;
                    pre_right = 0;                  
                }
                pre_static += 1;
            }
        }
        return ans;
    }
}
