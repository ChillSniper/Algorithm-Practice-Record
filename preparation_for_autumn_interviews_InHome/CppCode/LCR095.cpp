#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int longestCommonSubsequence(string text1, string text2) {
        int lenA = text1.size(), lenB = text2.size();
        vector<vector<int>> dp(lenA + 1, vector<int>(lenB + 1, 0));
        for (int i = 0;i < lenA;i ++) {
            for (int j = 0;j < lenB;j ++) {
                char x = text1[i];
                char y = text2[j];
                if (x == y) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        
        return dp[lenA][lenB];
    }
};

int main() {
    return 0;
}