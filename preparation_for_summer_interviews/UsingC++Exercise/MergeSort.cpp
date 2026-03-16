#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

#define Test

void MergeSort(vector<int>& a, int l, int r);
void MergeTwoList(vector<int>& a, int al, int ar, int bl, int br);

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
    MergeSort(a, 0, n - 1);
    for (int i = 0;i < n;i ++) {
        printf("%d ", a[i]);
    }
    return 0;
}

void MergeSort(vector<int>& a, int l, int r) {
    if (l >= r) {
        return ;
    }
    int mid = l + ((r - l) >> 1);
    MergeSort(a, l, mid);
    MergeSort(a, mid + 1, r);
    MergeTwoList(a, l, mid, mid + 1, r);
    return ;
}

void MergeTwoList(vector<int>& a, int al, int ar, int bl, int br) {
    int lenA = ar - al + 1;
    int lenB = br - bl + 1;
    int lenAll = lenA + lenB;
    vector<int> record(lenAll, 0);
    int i = al, j = bl, index = 0;
    while (i <= ar && j <= br) {
        if (a[i] <= a[j]) {
            record[index ++] = a[i ++];
        } else {
            record[index ++] = a[j ++];
        }
    }
    while (i <= ar) {
        record[index ++] = a[i ++];
    }
    while (j <= br) {
        record[index ++] = a[j ++];
    }
    for (int k = 0;k < lenAll;k ++){
        a[al + k] = record[k];
    }
}