package com.herbert.ContestDoubleWeek175;

public class T1 {
    public String reverseByType(String s) {
        char[] str = s.toCharArray();
        int sz = str.length;
        int i = 0, j = sz - 1;
        while (i < j && i < sz && j > -1) {
            while (i < sz && (str[i] < 'a' || str[i] > 'z')) {
                ++ i;
            }
            while (j > -1 && (str[j] < 'a' || str[j] > 'z')) {
                -- j;
            }
            if (i < j) {
                char t = str[i];
                str[i] = str[j];
                str[j] = t;
                ++ i;
                -- j;
            }
        }
        i = 0;
        j = sz - 1;
        while (i < j && i < sz && j > -1) {
            while (i < sz && (str[i] >= 'a' && str[i] <= 'z')) {
                ++ i;
            }
            while (j > -1 && (str[j] >= 'a' && str[j] <= 'z')) {
                -- j;
            }
            if (i < j) {
                char t = str[i];
                str[i] = str[j];
                str[j] = t;
                ++ i;
                -- j;
            }
        }
        return new String(str);
    }
}
