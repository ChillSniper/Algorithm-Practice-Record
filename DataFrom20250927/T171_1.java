import java.util.*;

public class T171_1 {
    public boolean completePrime(int num) {
        // 71315
        List<Integer> record = new ArrayList<>(); 
        while (num > 0) {
            int p = num % 10;
            num /= 10;
            record.add(p);

        }
        int t = 1, n = record.size(), ori = 0;
        for (int i = 0;i < n;i ++) {
            ori = ori + record.get(i) * t;
            t *= 10;
            if (!isPrime(ori))
                return false;
        }
        ori = 0;
        for (int i = n - 1;i >= 0;i --) {
            ori = ori * 10 + record.get(i);
            if (!isPrime(ori))
                return false;
        }
        return true;
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