#include <bits/stdc++.h>
using namespace std;

// #define A

#define B

class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {

        int n = nums.size();
        // A way: dp algorithm
        // B way: greedy algorithm
        #ifdef A

            int ans = 0;

            vector<int> dp(n, 0);

            for (int i = 0;i < n;i ++) {
                dp[i] = 1;
                for (int j = 0;j < i;j ++) {
                    if (nums[i] > nums[j]) {
                        dp[i] = max(dp[j] + 1, dp[i]);
                    }
                }

                ans = max(ans, dp[i]);
            }

            return ans;
        #endif

        #ifdef B
            // the pos ?
            vector<int> g;

            for (int i = 0;i < n;i ++) {
                int val = nums[i];

                int index = binarySearch(g, val);

                int sz_g = g.size();

                if (index >= sz_g) {
                    g.push_back(val);
                } else {
                    g[index] = val;
                }

            }

            return g.size();
        #endif
        
    }

private:

    int binarySearch(vector<int>& nums, int target) {
        int n = nums.size();

        int left = 0, right = n - 1;

        while (left <= right) {
            int mid = (left + right) >> 1;

            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
};

int main() {

    return 0;
}