#include <bits/stdc++.h>
using namespace std;

void QuickSort(vector<int>& nums, int l, int r) {
    if (l >= r) {
        return ;
    }
    int partition = nums[l], i = l - 1, j = r + 1;
    while (i < j) {
        do i ++; while (nums[i] < partition);
        do j --; while (nums[j] > partition);
        if (i < j) {
            swap(nums[i], nums[j]);
        }
    }
    QuickSort(nums, l, j);
    QuickSort(nums, j + 1, r);
}

int main() {
    vector<int> nums = {9, 7, 6, 2, 3, 5, 8, 4, 1, 2, 8, 1, 10, 2};
    QuickSort(nums, 0, (int)nums.size() - 1);
    for (int i = 0;i < nums.size();i ++) {
        cout << nums[i] << " ";
    }
    return 0;
}