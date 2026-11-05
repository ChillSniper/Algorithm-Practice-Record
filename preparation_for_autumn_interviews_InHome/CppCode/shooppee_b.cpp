#include <bits/stdc++.h>
using namespace std;


class Solution {
public:
    /**
     * Note: 类名、方法名、参数名已经指定，请勿修改
     *
     * 
     * 对于一个整数N (N>=1024)，计算2的N次方并在屏幕显示十进制结果。
     * @param n int整型  
     * @return string字符串
     */
    string Power2N(int n) {
        // write code here
        string ans = "1";
        for (int k = 0;k < n;k ++) {
            int carry = 0;

            for (int i = ans.size() - 1;i >= 0;i --) {
                int x = (ans[i] - '0') * 2 + carry;
                ans[i] = x % 10 + '0';

                carry = x / 10;
            }

            if (carry) {
                ans.insert(ans.begin(), carry + '0');
            }
        }
        return ans;
    }
};
