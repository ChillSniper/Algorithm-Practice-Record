#include <bits/stdc++.h>
using namespace std;

using ll = long long;

class Solution {
public:
    long long getDescentPeriods(vector<int>& prices) {
        ll ans = 0;
        int n = prices.size();

        for (int i = 0;i < n;i ++) {
            int val = prices[i];
            int j = i;
            while (j + 1 < n && prices[j + 1] == prices[j] - 1) {
                j ++;
            }
            ll len = j - i + 1;
            i = j;
            ans += (len + 1) * len / 2;
        }

        return ans;
    }
};