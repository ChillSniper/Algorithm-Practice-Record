#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int majorityElement(vector<int>& nums) {
        auto vote = 0, cnt = 0;
        for (auto val : nums) {
            if (cnt == 0) {
                vote = val;
            }
            cnt += val == vote ? 1 : -1;
        }
        return vote;
    }
};