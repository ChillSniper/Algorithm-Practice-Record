#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int n = prices.size();
        int ans = 0, minval = INT_MAX / 2;
        for (int i = 0;i < n;i ++) {
            int x = prices[i];
            if (x < minval) {
                minval = x;
            } else {
                ans = max(ans, x - minval);
            }
        }      
        return ans;
    }
};