#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    void nextPermutation(vector<int>& nums) {
        // 6513247
        // 6513274
        // 6513427
        // 12345
        // 12354
        // 12435
        int n = nums.size();
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            -- i;
        }
        int j = n - 1;
        if (i >= 0) {
            while (j >= 0 && nums[i] >= nums[j]) {
                -- j;
            }
            if (j >= 0) {
                swap(nums[i], nums[j]);
            }
        }
        reverse(nums.begin() + i + 1, nums.end());
    }
};