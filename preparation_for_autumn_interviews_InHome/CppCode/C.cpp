#include <bits/stdc++.h>
using namespace std;


class Solution {
public:
    /**
     * Note: 类名、方法名、参数名已经指定，请勿修改
     *
     * 
     * 
     * @param k int整型  
     * @param w int整型  
     * @param profits int整型 vector 
     * @param capital int整型 vector 
     * @return int整型
     */
    int findMaximizedCapital(int k, int w, vector<int>& profits, vector<int>& capital) {
        // write code here
        int n = profits.size();
        int final_weight = 0;
        vector<int> vis(n, 0);
        for (int i = 0;i < k;i ++) {
            int getval = func(vis, profits, capital, w);
            w += getval;
        }
        return w;
    }
    int func(vector<int>& vis, vector<int>& profits, vector<int>& capital, int cur_w) {
        int n = vis.size();
        int index = -1;
        int ps = 0;
        for (int i = 0;i < n;i ++) {
            if (vis[i] == 1) {
                continue;
            }
            if (capital[i] <= cur_w && profits[i] >= ps) {
                ps = profits[i];
                index = i;
            }
        }
        if (index == -1)
            return 0;

        vis[index] = 1;
        return ps;
    }
};
