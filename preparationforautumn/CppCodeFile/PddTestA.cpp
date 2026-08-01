#include <iostream>
#include <cstring>
#include <cstdio>
#include <algorithm>
#include <vector>
#include <unordered_map>
#define Test
using namespace std;

using ll = long long;

int main() {
    #ifdef Test
        freopen("input", "r", stdin);
        freopen("output", "w", stdout);
    #endif
    int n;
    cin >> n;
    if (n >= 46) {
        printf("-1");
        return 0;
    }
    vector<int> record;
    int curx = 9;
    int t = n;
    while (t > 0) {
        int val = min(curx, t);
        record.push_back(val);
        curx -= 1;
        t -= val;
    }
    int sz = record.size();
    ll ans = 0;
    for (int i = sz - 1;i >= 0;-- i) {
        ans = ans * 10 + record[i];
    }
    printf("%lld", ans);
    return 0;
}
