import java.util.*;

public class T172_2 {
    public int maximumSum(int[] nums) {
        // 1 or 0 or 2
        // 1 + 2 + 0
        // 1 + 1 + 1
        // 2 + 2 + 2
        // 0 + 0 + 0
        Arrays.sort(nums);
        List<Integer> zeroList = new ArrayList<>();
        List<Integer> oneList = new ArrayList<>();
        List<Integer> twoList =  new ArrayList<>();
        for (int x : nums) {
            if (x % 3 == 0) {
                zeroList.add(x);
            } else if(x % 3 == 1) {
                oneList.add(x);
            } else {
                twoList.add(x);
            }
        }
        int ans = 0;
        int sz_0 = zeroList.size(), sz_1 = oneList.size(), sz_2 = twoList.size();
        if (sz_0 > 0 && sz_1 > 0 && sz_2 > 0) {
            ans = Math.max(ans, zeroList.get(sz_0 - 1) + oneList.get(sz_1 - 1) + twoList.get(sz_2 - 1));
        }
        if (sz_1 >= 3) {
            ans = Math.max(ans, oneList.get(sz_1 - 1) + oneList.get(sz_1 - 2) + oneList.get(sz_1 - 3));
        }
        if (sz_2 >= 3) {
            ans = Math.max(ans, oneList.get(sz_2 - 1) + oneList.get(sz_2 - 2) + oneList.get(sz_2 - 3));
        }
        if (sz_0 >= 3) {
            ans = Math.max(ans, oneList.get(sz_0 - 1) + oneList.get(sz_0 - 2) + oneList.get(sz_0 - 3));
        }
        return ans;
    }

}
