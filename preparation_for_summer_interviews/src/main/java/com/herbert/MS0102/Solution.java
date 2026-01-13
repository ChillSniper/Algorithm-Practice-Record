package com.herbert.MS0102;

class Solution {
    public boolean CheckPermutation(String s1, String s2) {
        int la = s1.length(), lb = s2.length();

        if (la != lb)
            return false;

        int[] r = new int[26];
        for (int i = 0;i < la;i ++)
            r[s1.charAt(i) - 'a']++;

        for (int i = 0;i < lb;i ++) {
            int index = s2.charAt(i) - 'a';
            if (--r[index] < 0)
                return false;
        }

        for (int i = 0;i < 26;i ++) {
            if (r[i] > 0)
                return false;
        }

        return true;
    }
}