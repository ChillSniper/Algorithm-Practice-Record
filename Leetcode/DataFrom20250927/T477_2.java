import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T477_2 {
    public static void main(String[] args) {
        int[] ans = new int[]{3, 1, 3, 2, 0};
        T477_2 t = new T477_2();
        t.maxBalancedSubarray(ans);
    }
    public int maxBalancedSubarray(int[] nums) {
        int n = nums.length;
        int[] ji = new int[n + 1], ou = new int[n + 1], xor_val = new int[n + 1];
        Map<Integer, List<Integer>> erase = new HashMap<>();
        int ans = 0;
        erase.computeIfAbsent(0, k -> new ArrayList<>()).add(-1);
        for (int i = 0;i < n;i ++) {
            ji[i + 1] = ji[i] + (nums[i] % 2 == 1 ? 1 : 0);
            ou[i + 1] = ou[i] + (nums[i] % 2 == 0 ? 1 : 0);
            xor_val[i + 1] = xor_val[i] ^ nums[i];
            int t = xor_val[i + 1];
            if (erase.containsKey(t)) {
                List<Integer> indexs = erase.get(t);
                for (int index : indexs) {
                    int jn = ji[i + 1] - ji[index + 1];
                    int on = ou[i + 1] - ou[index + 1];
                    if (jn == on) {
                        ans = Math.max(ans, i - index);
                    }
                }  
            } 
            erase.computeIfAbsent(t, k -> new ArrayList<>()).add(i);
        }
        return ans;
    }
}
