// #include <bits/stdc++.h>

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

#define Test

void QuickSort(vector<int>& a, int l, int r);

int FindMId(vector<int>& a, int l,  int r);

int main() {
    #ifdef Test
        freopen("file.in", "r", stdin);
        freopen("file.out", "w", stdout);
    #endif

    int n;
    scanf("%d", &n);
    vector<int> a(n, 0);

    for (int i = 0;i < n;i ++) {
        scanf("%d", &a[i]);
    }

    QuickSort(a, 0, n - 1);
    for (int i = 0;i < n;i ++) {
        printf("%d ", a[i]);
    }
    return 0;
}

void QuickSort(vector<int>& a, int l, int r) {
    if (l >= r)
        return ;
    int mid = FindMId(a, l, r);
    QuickSort(a, l, mid - 1);
    QuickSort(a, mid + 1, r);
}

int FindMId(vector<int>& a, int l, int r) {
    int privot = a[l];
    int i = l, j = r;
    while (i < j) {
        while (j > i && a[j] >= privot) {
            -- j;
        }
        while (i < j && a[i] <= privot) {
            ++ i;
        }
        if (i < j) {
            swap(a[i], a[j]);
        }
    }
    swap(a[i], a[l]);
    return i;
}