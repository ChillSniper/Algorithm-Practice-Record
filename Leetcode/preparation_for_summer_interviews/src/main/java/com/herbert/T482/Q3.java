package com.herbert.T482;

import java.util.HashSet;
import java.util.Set;

public class Q3 {
    public static void main(String[] args) {
        int k = 3;
        Q3 q = new Q3();
        int ans = q.minAllOneMultiple(k);
        System.out.println(ans);
    }
    public int minAllOneMultiple(int k) {

        // // 10000000000000000000000
        //     // 69
        // BigInteger _k = new BigInteger(Integer.toString(k));
        // BigInteger x = new BigInteger("1");
        // int len = 1;
        // while (len < 2000) {
        //     BigInteger val = x.mod(_k);
        //     if (val.equals(BigInteger.ZERO)) {
        //         return len;
        //     }
        //     ++ len;
        //     x = x.multiply(BigInteger.TEN).add(BigInteger.ONE);
        // }   
        // return -1;
        int cur_mod = 1, all_mod = 1;
        int len = 1;
        Set<Integer> record = new HashSet<>();
        while (true) {
            if (record.contains(all_mod)) {
                return -1;
            }
            record.add(all_mod);
            if (all_mod % k == 0)
                return len;
            all_mod %= k;
            ++ len;
            cur_mod = ((cur_mod) * 10) % k;
            all_mod += cur_mod;
            all_mod %= k;
        }
    }
}
