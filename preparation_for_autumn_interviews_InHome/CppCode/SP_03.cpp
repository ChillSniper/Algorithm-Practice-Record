#include <bits/stdc++.h>
using namespace std;

using ll = long long;

class Solution {
public:
    /**
     * Note: 类名、方法名、参数名已经指定，请勿修改
     *
     * 
     * 返回能组成三角形的组合数量
     * @param n int整型  那条线段
     * @param lens int整型 vector 大小为n的数组，表示每条线段长度
     * @return long长整型
     */
    long long Solve(int n, vector<int>& lens) {
        // write code here
        ll ans = 0;
        sort(lens.begin(), lens.end());
        
        for (int maxLenIndex = 2;maxLenIndex < n;maxLenIndex ++) {
            int left = 0, right = maxLenIndex - 1;
            while (left < right) {
                if (lens[left] + lens[right] > lens[maxLenIndex]) {
                    ans += right - left;
                    -- right;
                } else {
                    ++ left;
            }
        }
    }
        return ans;
    }
};