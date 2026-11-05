#include <bits/stdc++.h>
using namespace std;

class Solution {
private:
    const int DIR[4][2] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
public:
    int trapRainWater(vector<vector<int>>& heightMap) {
        int ans = 0;
        int n = heightMap.size();
        int m = heightMap[0].size();
        priority_queue<tuple<int, int, int>, vector<tuple<int, int, int>>, greater<>> pq;
        for (int i = 0;i < n;i ++) {
            for (int j = 0;j < m;j ++) {
                if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
                    pq.push(make_tuple(heightMap[i][j], i, j));
                    heightMap[i][j] = -1;
                }
            }
        }
        while (pq.size() > 0) {
            auto& [height, curi, curj] = pq.top();
            pq.pop();
            for (int i = 0;i < 4;i ++) {
                int x = curi + DIR[i][0];
                int y = curj + DIR[i][1];
                if (x < 0 || x >= n || y < 0 || y >= m) {
                    continue;
                }
                if (heightMap[x][y] == -1) {
                    continue;
                }
                if (heightMap[x][y] >= height) {
                    pq.emplace(heightMap[x][y], x, y);
                    heightMap[x][y] = -1;
                } else {
                    ans += height - heightMap[x][y];
                    pq.emplace(height, x, y);
                    heightMap[x][y] = -1;
                }
            }
        }
        return ans;
    }
};