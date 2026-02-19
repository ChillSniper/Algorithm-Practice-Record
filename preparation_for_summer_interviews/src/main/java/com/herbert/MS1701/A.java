package com.herbert.MS1701;

public class A {
    public int add(int a, int b) {
        // a ^ b xor is add without add bit
        // (a & b) >> 1 is add with add bit
        int x = a ^ b;
        // int y = (a & b) >> 1;
        // fucking bug, remember that << 1 is mul 2, >> 1 is div 2;
        int y = (a & b) << 1;
        while (y != 0) {
            int t = x ^ y;
            // y = (x & y) >> 1;
            // foolish bug, * 2 means << 1, not >> 1, >> 1 means div 2, fuck !
            y = (x & y) << 1;
            x = t;
        }
        return x;
    }
}
