#include <bits/stdc++.h>
using namespace std;



class Solution {
public:
    /**
     * Note: 类名、方法名、参数名已经指定，请勿修改
     *
     * 
     * 
     * @param rooms int整型 vector<vector<>> 房间
     * @param startPoint int整型 vector 起始点
     * @param endPoint int整型 vector 终点
     * @return int整型
     */
    int minimumInitHealth(vector<vector<int> >& rooms, vector<int>& startPoint, vector<int>& endPoint) {
        // write code here
        int sr = startPoint[0];
        int sc = startPoint[1];
        int er = endPoint[0];
        int ec = endPoint[1];

        int m = rooms.size();
        int n = rooms[0].size();

        const int INF = INT_MAX / 2;
        
        vector<vector<int>> dp(m, vector<int>(n, INF));

        dp[er][ec] = max(1, 1 - rooms[er][ec]);

        int rowStep = (er >= sr ? 1 : -1);
        int colStep = (ec >= sc ? 1 : -1);

        for (int i = er; ; i -= rowStep) {
            for (int j = ec; ; j -= colStep) {
                if (!(i == er && j == ec)) {
                    int nextNeed = INF;

                    int ni = i + rowStep;
                    if (ni >= 0 && ni < m) {
                        if ((rowStep == 1 && ni <= er) || (rowStep == -1 && ni >= er)) {
                            nextNeed = min(nextNeed, dp[ni][j]);
                        }
                    }

                    int nj = j + colStep;

                    if (nj >= 0 && nj < n) {
                        if ((colStep == 1 && nj <= ec) || (colStep == -1 && nj >= ec)) {
                            nextNeed = min(nextNeed, dp[i][nj]);
                        }
                    }

                    dp[i][j] = max(1, nextNeed - rooms[i][j]);
                }
                if (j == sc) {
                    break;
                }
            }
            if (i == sr) {
                break;
            }
        }

        return dp[sr][sc];
    }
};
