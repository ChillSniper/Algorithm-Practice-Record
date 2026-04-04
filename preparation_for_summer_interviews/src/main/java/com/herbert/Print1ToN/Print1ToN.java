package com.herbert.Print1ToN;

import java.util.Scanner;

public class Print1ToN {
    private final Object lock = new Object();
    private int state = 1;
    private final int n;

    public Print1ToN(int _n) {
        this.n = _n;
    }

    public void print(int Id) {
        while (true) { 
            synchronized(lock) {
                while (state <= this.n && (state - 1) % 3 != Id) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return ;
                    }
                }

                if (state > n) {
                    lock.notifyAll();
                    return ;
                }
                System.out.println(state + " ");
                ++ state;
                lock.notifyAll();
            }
            
        }
    }

    public static void main(String[] args) {
        int x;
        Scanner sc = new Scanner(System.in);

        x = sc.nextInt();

        sc.close();

        Print1ToN p = new Print1ToN(x);

        Thread t1 = new Thread(() -> p.print(0));
        Thread t2 = new Thread(() -> p.print(1));
        Thread t3 = new Thread(() -> p.print(2));

        t1.start();
        t2.start();
        t3.start();
    }
}
