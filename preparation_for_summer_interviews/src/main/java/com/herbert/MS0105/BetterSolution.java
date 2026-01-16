package com.herbert.MS0105;

public class BetterSolution {
    public boolean oneEditAway(String first, String second) {
        int n = first.length(), m = second.length();
        if (Math.abs(n - m) > 1)
            return false;
        if (n > m)
            return oneEditAway(second, first);
        int cnt = 0, i = 0, j = 0;
        while (i < n && j < m) {
            char x = first.charAt(i), y = second.charAt(j);
            if (x == y) {
                ++ i;
                ++ j;
            } else {
                if (n == m) {
                    ++ i;
                    ++ j;
                    ++ cnt;
                } else {
                    ++ j;
                    ++ cnt;
                    
                }
                if (cnt > 1)
                    return false;
            }
        }
        return cnt < 2;
    }
}
