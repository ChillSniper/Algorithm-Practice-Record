#include <bits/stdc++.h>
using namespace std;

/*
题目描述：给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的两个整数，并返回它们的数组下标。
假设每种输入只会对应一个答案，且同一个元素不能使用两次。
示例：
输入：nums = [2, 7, 11, 15], target = 9
输出：[0, 1]
解释：nums + nums = 2 + 7 = 9
要求：
• 时间复杂度 O(n)，空间复杂度 O(n)。
• 使用哈希表实现
*/

int main() {
    int n;
    cin >> n;
    vector<int> nums(n, 0);
    for (int i = 0;i < n;i ++) {
        cin >> nums[i];
    }
    int target;
    cin >> target;
    unordered_map<int, int> record;
    vector<int> ans(2, 0);
    for (int i = 0;i < n;i ++) {
        int val = nums[i];
        if (record.count(target - nums[i])) {
            ans[0] = i;
            ans[1] = record[target - nums[i]];
        } else {
            record[val] = i;
        }
    }
    cout << ans[0] << " " << ans[1] << endl;
    return 0;
}