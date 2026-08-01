#include <iostream>
#include <cstdio>
#include <cstring>
#include <algorithm>
#include <vector>

using namespace std;

using ll = long long;

class Solution {
public:
    int maximumProduct(vector<int>& nums) {
        int n = nums.size();      
        sort(nums.begin(), nums.end());
        ll ans = -1e9;
        ll x = nums[0] * nums[1] * nums[n - 1];
        ll y = nums[n - 1] * nums[n - 2] * nums[n - 3];
        return x >= y ? x : y;
    }
};

int main() {
    return 0;
}