#include <iostream>
#include <stdio.h>
#include <algorithm>
#include <cstring>
#include <vector>
#include <math.h>
// #include <bits/stdc++.h>

using namespace std;

class Solution {
public:
    int trap(vector<int>& height) {
        int n = height.size();
        int result = 0;
        vector<int> lf(n, 0), ri(n, 0);
        for (int i = 1;i < n;i ++) {
            lf[i] = max(lf[i - 1], height[i - 1]);
        }
        for (int i = n - 2;i >= 0;i --) {
            ri[i] = max(ri[i + 1], height[i + 1]);
        }
        for (int i = 0;i < n;i ++) {
            result += min(lf[i], ri[i]) >= height[i] ? min(lf[i], ri[i]) - height[i] : 0;
        }
        return result;
    }

};

int main() {

    return 0;
}
