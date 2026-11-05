#include <bits/stdc++.h>
using namespace std;


class Solution {
public:
    /**
     * Note: 类名、方法名、参数名已经指定，请勿修改
     *
     * 
     * 
     * @param cases int整型 vector 每段代码对应的测试用例数目
     * @return int整型
     */
    int minEffort(vector<int>& cases) {
        // write code here
        int ans = 0;
        priority_queue<int, vector<int>, greater<int>> pq;
        for (auto item : cases) {
            pq.push(item);
        }       
        while (pq.size() > 1) {
            int x = pq.top();
            pq.pop();
            int y = pq.top();
            pq.pop();
            ans += x + y;
            pq.push(x + y);
        }
        return ans;
    }
};
