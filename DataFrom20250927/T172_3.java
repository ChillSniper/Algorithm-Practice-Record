import java.util.*;

public class T172_3 {
    public long maximumScore(int[] nums, String s) {
        int cnt = 0, sz = s.length();
        long ans = 0; 
        TreeMap<Integer, Integer> record = new TreeMap<>();
        int lf = 0, MaxVal = 0, Index = -1, st = 0; 
        for (int i = 0;i < sz;i ++) {
            while (st < sz && s.charAt(st) != '1') {
                ++ st;
                record.merge(nums[st], 1, Integer::sum);
                if (nums[st] > MaxVal) {
                    MaxVal = nums[st];
                    Index = st;
                }
            }
            if (st == sz)
                break;
            if (!record.isEmpty() && record.lastKey() > nums[st]) {
                // delete lf, index - 1
                // add st
                // i = st
                // maxval = 0
            } else {
                // delete lf, st - 1
                
            }
        }

    }
}
