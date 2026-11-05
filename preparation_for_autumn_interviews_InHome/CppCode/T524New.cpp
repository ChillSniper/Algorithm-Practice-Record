#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    string findLongestWord(string s, vector<string>& dictionary) {
        string ans = "";
        int m = s.length();
        vector<vector<int>> dp(m + 1, vector<int>(26, 0));
        std::fill(dp[m].begin(), dp[m].end(), m);

        for (int i = m - 1;i >= 0;i --) {
            char ch = s[i];
            for (int j = 0;j < 26;j ++) {
                if (ch - 'a' == j) {
                    dp[i][j] = i;
                } else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }

        for (auto item_string : dictionary) {
            int size_item = item_string.length();

            int index = 0;
            bool enable_flag = true;
            for (int i = 0;i < size_item;i ++) {
                char ch = item_string[i];
                if (index == m || dp[index][ch - 'a'] == m) {
                    enable_flag = false;
                    break;
                } else {
                    index = dp[index][ch - 'a'] + 1;
                }
            }

            if (enable_flag && (size_item > ans.size() || size_item == ans.size() && item_string < ans)) {
                ans = item_string;
            }
        }

        return ans;
    }
};
