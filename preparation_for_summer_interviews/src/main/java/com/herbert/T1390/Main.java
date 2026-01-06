package com.herbert.T1390;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private Map<Integer, Integer> record = new HashMap<>();
    public int sumFourDivisors(int[] nums) {
        int ans = 0;
        for (int x : nums) {
            ans += GetResult(x);
        }
        return ans;
    }
    private int GetResult(int x) {
        if (record.containsKey(x))
            return record.get(x);
        int cnt = 0, result = 0;
        for (int i = 1;i <= x;i ++) {
            if (x % i == 0) {
                result += i;
                cnt ++;
                if (cnt > 4) {
                    record.put(x, 0);
                    return 0;
                }
            }
        }
        if (cnt == 4) {
            record.put(x, result);
        } else {
            record.put(x, 0);
        }
        return record.get(x);
        // return cnt == 4 ? result : 0;
    }
}
