#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    string longestPalindrome(string s) {
        int n = s.size();
        vector<vector<bool>> dp(n, vector<bool>(n, false));
        for (int i = 0;i < n;i ++) {
            dp[i][i] = true;
        }
        
        int max_size = 1, st = 0;
        for (int len = 2;len <= n;len ++) {
            for (int i = 0;i + len - 1 < n;i ++) {
                if (len <= 2) {
                    dp[i][i + len - 1] = s[i] == s[i + len - 1];
                    if (dp[i][i + len - 1] && len > max_size) {
                        max_size = len;
                        st = i;
                    }
                    // break;
                    continue;
                }
                if (s[i] != s[i + len - 1]) {
                    continue;
                }
                dp[i][i + len - 1] = dp[i + 1][i + len - 2];
                if (dp[i][i + len - 1] && len > max_size) {
                    max_size = len;
                    st = i;
                }
            }
        }
        return s.substr(st, max_size);
    }
};

int main() {
    string s = "aacabdka";
    Solution t;
    string ans = t.longestPalindrome(s);
    cout << ans << endl;
    return 0;
}