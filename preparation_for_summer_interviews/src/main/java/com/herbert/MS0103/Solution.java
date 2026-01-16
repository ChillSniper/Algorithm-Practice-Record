package com.herbert.MS0103;

public class Solution {
    public String replaceSpaces(String S, int length) {
        int cnt = 0;
        for (int i = 0;i < length;i ++) {
            if (S.charAt(i) == ' ')
                cnt++;
        }
        int newLength = length + cnt * 2;
        int idx = 0;
        char[] ch = new char[newLength];
        for (int i = 0;i < length;i ++) {
            if (S.charAt(i) != ' ') {
                ch[idx ++] = S.charAt(i);
            } else {
                ch[idx ++] = '%';
                ch[idx ++] = '2';
                ch[idx ++] = '0';
            }
        }
        return new String(ch);
    }
}
