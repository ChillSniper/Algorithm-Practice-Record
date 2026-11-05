#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        vector<int> dp(amount + 1, INT_MAX / 2);
        dp[0] = 0;
        int n = coins.size();
        for (int i = 0;i < n;i ++) {
            int val = coins[i];
            for (int j = val;j <= amount;j ++) {
                dp[j] = min(dp[j - val] + 1, dp[j]);
            }
        }      
        return dp[amount] >= INT_MAX / 3 ? -1 : dp[amount];
    }
};