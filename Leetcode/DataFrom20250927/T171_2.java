import java.util.*;

public class T171_2 {
    public static void main(String[] args) {
        int x = 219;
        List<Integer> record = new ArrayList<>();
        while (x > 0) {
            int p = x % 2;
            x /= 2;
            record.add(p);
        }
        int n = record.size();
        for (int i = 0;i < n;i ++) {
            int k = record.get(i);
            System.out.print(k);
        }
        // 100 0 0011 1 011
        // 2 + 8 + 16 + 32  -64
    }
    
    public int[] minOperations(int[] nums) {
        // + or - get the result may be same
        // 101001011
        // 0 0
        // 1 1
        // 1 0
        // 0 1
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0;i < n;i ++) {
            ans[i] = getAns(nums[i]);
        }
        return ans;
    }
    private int getAns(int x) {
        List<Integer> record = new ArrayList<>();
        while (x > 0) {
            int p = x % 2;
            x /= 2;
            record.add(p);
        }
        int n = record.size(), i = 0, j = n - 1;
        // n = 4  2 1
        // n = 3 1
        int ans = 0;
        for (;i < j;i ++, j --) {
            int xi = record.get(i), xj = record.get(j);
            int numi = (int)Math.pow(2, i), numj = (int)Math.pow(2, j);
            if (xi == 0 && xj == 1) {
                if (Math.abs(ans + numi) < Math.abs(ans - numj)) {
                    ans = ans + numi;
                } else {
                    ans = ans - numj;
                }
            } else if (xi == 1 && xj == 0) {
                if (Math.abs(ans - numi) < Math.abs(ans + numj)) {
                    ans = ans - numi;
                } else {
                    ans = ans + numj;
                }

            } else if (xi == 0 && xj == 0) {
                int s = numi + numj;
                if (Math.abs(ans + s) < Math.abs(ans)) {
                    ans = ans + s;
                } else {
                    
                }
            } else {
                int s = numi + numj;
                if (Math.abs(ans - s) < Math.abs(ans)) {
                    ans = ans - s;
                } else {
                    
                }
            }
            
        }

        
        // 1 2 4 8 16 32 64
        return Math.abs(ans);
    }
}
