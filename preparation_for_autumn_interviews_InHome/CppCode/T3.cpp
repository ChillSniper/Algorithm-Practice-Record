#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int ans = 0;
        int cnt[256] = {0};
        
        int cur_len = 0;
        auto n = s.size();
        int st = 0;
        for (int i = 0;i < n;i ++) {
            char ch = s[i];
            cnt[ch] ++;
            while (st < i && cnt[ch] > 1) {
                -- cnt[s[st]];
                ++ st;
            }
            ans = max(ans, i - st + 1);
        }
        return ans;
    }
};