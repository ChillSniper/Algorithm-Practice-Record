#include <bits/stdc++.h>

using namespace std;

class Solution {
public:
    /**
     * Note: 类名、方法名、参数名已经指定，请勿修改
     *
     * 
     * find min override sub string
     * @param source string字符串  
     * @param target string字符串  
     * @return string字符串
     */
    string findMinOverrideSubString(string source, string target) {
        // write code here
        int st = -1;
        int szSource = source.size();
        int szTarget = target.size();
        int minLen = szSource + 1;
        for (int i = 0;i < szSource;i ++) {
            if (source[i] == target[0]) {
                int j = i;
                int k = 0;
                while (j < szSource && k < szTarget) {
                    if (source[j] == target[k]) {
                        j ++;
                        k ++;
                    } else {
                        j ++;
                    }
                }
                if (k == szTarget) {
                    if (j - i < minLen) {
                        minLen = j - i;
                        st = i;
                    }
                }
            } else {
                continue;
            }
        }
        if (minLen <= szSource) {
            return source.substr(st, minLen);
        } else {
            return "";
        }
    }
};
