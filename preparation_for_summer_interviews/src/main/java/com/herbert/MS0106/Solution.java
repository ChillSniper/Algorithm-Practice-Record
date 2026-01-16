package com.herbert.MS0106;

public class Solution {
    public String compressString(String S) {
        StringBuilder t = new StringBuilder();
        int sz = S.length();
        for (int i = 0;i < sz;i ++) {
            char ch = S.charAt(i);
            int j = i;
            while (j < sz && S.charAt(j) == ch)
                ++ j;
            int cnt = j - i;
            i = j - 1;
            t.append(ch);
            t.append(cnt);
        }
        if (t.length() >= sz)
            return S;
        return t.toString();
    }
}
