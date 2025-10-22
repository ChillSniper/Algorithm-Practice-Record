import java.util.ArrayList;
import java.util.List;

public class T3349 {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        List<Integer> record = new ArrayList<>();   
        int n = nums.size();
        for (int i = 0;i < n;i ++) {
            int j = i + 1;
            while(j < n && nums.get(j) > nums.get(j - 1)) {
                ++ j;
            }
            int len = j - i;
            record.add(len);
            i = j - 1;
        }
        n = record.size();
        if(record.get(0) >= k * 2)
            return true;
        for (int i = 1;i < n;i ++) {
            if(record.get(i) >= k && record.get(i - 1) >= k)
                return true;
            if(record.get(i) >= k * 2)
                return true;
        }
        return false;
    }
}
