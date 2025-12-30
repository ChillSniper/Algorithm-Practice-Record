import java.util.*;

public class T479_2 {
    public int largestPrime(int n) {
        Set<Integer> record = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        int cur = 0;
        for (int i = 2;i <= n;i ++) {
            if (isPrime(i)) {
                list.add(i);
                record.add(i);
                cur += i;
            }
            if (cur > n)
                break;
        }
        int sz = list.size(), s = 0, ans = 0;
        for (int i = 0;i < sz;i ++) {
            s += list.get(i);
            if (s > n)
                break;
            if (record.contains(s) && s <= n) {
                ans = s;
            }
        }
        return ans;
    }
    private boolean isPrime(int x) {
        if (x <= 1)
            return false;
        for (long i = 2;i * i <= (long)x;i ++) {
            if (x % i == 0)
                return false;
        }
        return true;
    }
}
