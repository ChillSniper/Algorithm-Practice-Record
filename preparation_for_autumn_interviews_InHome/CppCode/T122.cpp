#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int profit_all = 0;
        int n = prices.size();
        for (int i = 1;i < n;i ++) {
            int val = prices[i] - prices[i - 1];
            if (val > 0) {
                profit_all += val;
            }
        }
        return profit_all;
    }
};

int main() {
    return 0;
}