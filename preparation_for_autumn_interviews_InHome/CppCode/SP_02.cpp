#include<bits/stdc++.h>
using namespace std;

int main() {
    int a, b, c;
    string s;
    cin >> s;
    int sz = s.size();
    int i = 0, cur = 0;
    for (;i < sz;i ++) {
        if (s[i] == ',') {
            break;
        }
        cur = cur * 10 + (s[i] - '0');
    }
    a = cur;
    ++ i;
    cur = 0;
    for (;i < sz;i ++) {
        if (s[i] == ',') {
            break;
        }
        cur = cur * 10 + (s[i] - '0');
    }
    b = cur;
    i ++;
    cur = 0;
    for (;i < sz;i ++) {
        if (s[i] == ',') {
            break;
        }
        cur =  cur * 10 + (s[i] - '0');
    }
    c  = cur;
    int all = a + b + c;
    int maxVal = max({a, b, c});
    int ans = min(all / 2, all - maxVal);
    cout << ans;
    return 0;
}