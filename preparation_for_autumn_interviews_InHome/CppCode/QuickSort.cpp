#include <bits/stdc++.h>
using namespace std;

void QuickSort(vector<int>& arr, int l, int r);

int FindMid(vector<int>& arr, int l, int r);

int main() {
    vector<int> arr = {1, 3, 2, 8 , 4, 6, 5};
    int n = arr.size();
    QuickSort(arr, 0, n - 1);
    for (auto item : arr) {
        printf("%d ", item);
    }
    return 0;
}


void QuickSort(vector<int>& arr, int l, int r) {
    if (l >= r) 
        return ;
    int mid = FindMid(arr, l, r);
    QuickSort(arr, l, mid - 1);
    QuickSort(arr, mid + 1, r);
}

int FindMid(vector<int>& arr, int l, int r) {
    int val = arr[l];
    if (l >= r)
        return l;
    int i = l, j = r;
    while (i < j) {
        while (j > i && arr[j] >= val) -- j;
        while (i < j && arr[i] <= val) ++ i;
        if (i < j) {
            swap(arr[i], arr[j]);
        }
    }
    swap(arr[l], arr[i]);
    return i;
}