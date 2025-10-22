import java.util.*;

public class T3350 {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int k, n = nums.size();
        List<Integer> recordLen = new ArrayList<>();
        for (int i = 0;i < n;i ++) {
            int j = i + 1;
            while(j < n && nums.get(j) > nums.get(j - 1)) 
                ++ j;
            int len = j - i;
            i = j - 1;
            recordLen.add(len);
        }
        n = recordLen.size();
        k = recordLen.get(0) / 2;
        for (int i = 1;i < n;i ++) {
            int pre = recordLen.get(i - 1), cur = recordLen.get(i);
            k = Math.max(k, cur / 2);
            k = Math.max(k, Math.min(pre, cur));
        }
        return k;
    }
}
