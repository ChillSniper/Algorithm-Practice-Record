#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        int n = nums.size();
        return quickSelect(nums, 0, n - 1, n - k);
    }
private:
    int quickSelect(vector<int>& nums, int l, int r, int k) {
        if (l == r) {
            return nums[k];
        }
        int partition = nums[l], i = l - 1, j = r + 1;
        while (i < j) {
            do i ++; while (nums[i] < partition);
            do j --; while (nums[j] > partition);
            if (i < j) {
                swap(nums[i], nums[j]);
            }
        }
        if (k <= j) {
            return quickSelect(nums, l, j, k);   
        }
        else {
            return quickSelect(nums, j + 1, r, k);
        }
    }
};