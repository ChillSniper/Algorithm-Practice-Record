package com.herbert.LCR16;

import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        String s;
        Scanner sc = new Scanner(System.in);
        Solution t = new Solution();
        s = sc.next();
        int ans = t.lengthOfLongestSubstring(s);
        System.out.println(ans);
        sc.close();
    }

    public int lengthOfLongestSubstring(String s) {
        char[] str = s.toCharArray();
        int[] record = new int[300];
        int ans = 1, n = s.length();
        if (n == 0)
            return 0;
        int i = 0, j = 1;
        record[str[0]] = 1;
        for (;j < n;j ++) {
            char ch = str[j];
            ++ record[ch];
            while (i < j && record[ch] > 1) {
                -- record[str[i]];
                i ++;
            }
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }
}