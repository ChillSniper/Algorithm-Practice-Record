#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        sort(intervals.begin(), intervals.end(), [](auto& x, auto& y) {
            if (x[0] == y[0])
                return x[1] < y[1];
            return x[0] < y[0];
        });      
        vector<vector<int>> ans;
        int sz = intervals.size();
        if (sz == 1)
            return intervals;
        int left = intervals[0][0];
        int right = intervals[0][1];
        for (int i = 1;i < sz;i ++) {
            vector<int>& cur = intervals[i];
            if (cur[0] > right) {
                ans.push_back({left, right});
                left = cur[0];
                right = cur[1];
                continue;
            }
            right = max(right, cur[1]);
        }
        ans.push_back({left, right});
        return ans;
    }
};

