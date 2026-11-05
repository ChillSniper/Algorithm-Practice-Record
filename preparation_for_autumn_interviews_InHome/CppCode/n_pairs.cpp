#include <bits/stdc++.h>
using namespace std;

int ans = 0;

void dfs(int n, int left, int right, string cur) {
    if (left == n && right == n) {
        ++ ans;
        cout << cur << endl;
        return ;
    }
    if (left < n) {
        dfs(n, left + 1, right, cur + "(");
    }
    if (right < left) {
        dfs(n, left, right + 1, cur + ")");
    }
}

int main() {
    int n;
    cin >> n;
    dfs(n, 0, 0, "");
    cout << "ans = " << ans;
    return 0;
}