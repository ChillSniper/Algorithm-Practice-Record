#include <bits/stdc++.h>
using namespace std;


class Solution {
public:
    /**
     * Note: 类名、方法名、参数名已经指定，请勿修改
     *
     * 
     * 
     * @param message string字符串  
     * @return string字符串
     */
    string reverseMessage(string message) {


        string tmp = "";
        int n = message.size();
        vector<string> record;
        for (int i = 0;i < n;i ++) {
            if (message[i] != ' ') {
                int j = i;
                string t = "";
                while (j < n && message[j] != ' ') {
                    ++ j;
                }
                record.push_back(message.substr(i, j - 1 - i + 1));
                i = j - 1;
            } else {
                ;
            }
        }
        message = "";
        message += record[0];
        int record_sz = record.size();
        for (int i = 1;i < record_sz;i ++) {
            message += " ";
            message += record[i];
        }

        // write code here
        n = message.size();
        
        
        int i = 0, j = 0;
        for (;i <= j && j < n;i ++, j ++) {
            if (message[j] != ' ') {
                while (j < n && message[j] != ' ') {
                    ++ j;
                }
                -- j;
                for (int left = i, right = j;left < right;left ++, right --) {
                    swap(message[left], message[right]);
                }
                j ++;
                i = j;
            }
        }
        for (int left = 0, right = n - 1;left < right;left ++, right --) {
            swap(message[left], message[right]);
        }
        return message;
    }

};
