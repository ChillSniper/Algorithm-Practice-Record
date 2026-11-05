#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int search(vector<int>& nums, int target) {
        // first pos of >= target
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

        if (left < 0 || left >= n || nums[left] > target)
            return -1;
        
        return left;
    }
};

int main() {
    
    return 0;
}