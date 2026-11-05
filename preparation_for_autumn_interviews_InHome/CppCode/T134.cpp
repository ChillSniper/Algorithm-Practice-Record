#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {
        auto sigma_gas = 0;
        auto sigma_cost = 0;
        for (auto val : gas)
            sigma_gas += val;

        for (auto val : cost) 
            sigma_cost += val;
        if (sigma_cost > sigma_gas)
            return -1;
        
        auto st = 0;
        auto n = gas.size();
        auto cur_left = 0;
        for (auto i = 0;i < n;i ++) {
            cur_left += (gas[i] - cost[i]);
            if (cur_left < 0) {
                cur_left = 0;
                st = i + 1;
            }
        }

        return st == n ? -1 : st;
    }
};