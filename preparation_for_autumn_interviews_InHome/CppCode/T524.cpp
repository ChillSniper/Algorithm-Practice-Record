#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    string findLongestWord(string s, vector<string>& dictionary) {
        vector<string> ans;

        for (auto& item : dictionary) {
            int i = 0, j = 0;
            int sz_item = item.size(), sz_s = s.size();
            for (;i < sz_item && j < sz_s;) {
                if (item[i] == s[j]) {
                    i ++;
                    j ++;
                } else {
                    j ++;
                }
            }
            if (i == sz_item) {
                ans.push_back(item);
            }
        }

        sort(ans.begin(), ans.end(), [](auto& x, auto& y) {
            if (x.size() != y.size()) {
                return y.size() < x.size();
            }
            return x < y;
        });

        return ans.size() == 0 ? "" : ans[0];
    }
};

int main() {

    return 0;
}