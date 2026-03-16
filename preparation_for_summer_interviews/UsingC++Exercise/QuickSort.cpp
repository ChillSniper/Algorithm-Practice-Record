#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

#define Test

void QuickSort(vector<int>& a, int l, int r);
int FindMid(vector<int>& a, int l, int r);

int main() {

    #ifdef Test
        freopen("file.in", "r", stdin);
        freopen("file.out", "w", stdout);
    #endif

    int n;
    scanf("%d", &n);
    vector<int> arr(n, 0);
    for (int i = 0;i < n;i ++) {
        scanf("%d", &arr[i]);
    }
    QuickSort(arr, 0, n - 1);
    for (int i = 0;i < n;i ++) {
        printf("%d ", arr[i]);
    }
    return 0;
}

void QuickSort(vector<int>& a, int l, int r) {
    if (l >= r) {
        return ;
    }
    int mid = FindMid(a, l, r);
    QuickSort(a, l, mid - 1);
    QuickSort(a, mid + 1, r);
}

int FindMid(vector<int>& a, int l, int r) {
    int val = a[l];
    int i = l, j = r;
    while (i < j) {
        while (j > i && a[j] >= val) {
            -- j;
        }
        while (i < j && a[i] <= val) {
            ++ i;
        }
        if (i < j) {
            swap(a[i], a[j]);
        }
    }
    swap(a[l], a[i]);
    return i;
}

// int FindMid(vector<int>& arr, int left, int right) {
//         int pivot = arr[left]; // 选定最左侧为基准
//         int i = left, j = right;
//         while (i < j) {
//             // 注意：一定要先从右往左找小于基准的数
//             while (i < j && arr[j] >= pivot) j--;
//             while (i < j && arr[i] <= pivot) i++;
//             if (i < j) {
//                 int temp = arr[i];
//                 arr[i] = arr[j];
//                 arr[j] = temp;
//             }
//         }
//         // 将基准值放到相遇的位置
//         arr[left] = arr[i];
//         arr[i] = pivot;
//         return i;
//     }