// 等会再写一下单例模式 OK
// 回溯算法那个
// 归并排序 这个不管了，这个我会的
// 看一下hot100
// codetop前三页
// 前中后序遍历二叉树的非递归实现
// 手撕数组的第k大元素

#include <bits/stdc++.h>
using namespace std;

int FindPrivotVal(vector<int>& a, int l, int r);
void QuickSort(vector<int>& a, int l, int r);

int main() {
    int n;
    
    scanf("%d", &n);
    vector<int> a(n);
    for (int i = 0;i < n;i ++) {
        scanf("%d", &a[i]);
    }
    QuickSort(a, 0, n - 1);
    for (int i = 0;i < n;i ++) {
        printf("%d ", a[i]);
    }
    return 0;
}

int FindPrivotVal(vector<int>& a, int l, int r) {
    if (l > r)
        return -1;
    if (l == r)
        return l;
    int privot = a[l];
    int i = l, j = r;
    while (i < j) {
        while (j > i && a[j] >= privot) -- j;
        while (i < j && a[i] <= privot) ++ i;
        if (i < j) {
            swap(a[i], a[j]);
        }
    }
    if (a[l] > a[i]) {
        swap(a[l], a[i]);
    }
    return i;
}

void QuickSort(vector<int>& a, int l, int r) {
    int len = r - l + 1;
    if (len <= 1)
        return ;
    int index = FindPrivotVal(a, l, r);
    QuickSort(a, l, index - 1);
    QuickSort(a, index + 1, r);
}
