package com.herbert.Print1ToN;

import java.util.Scanner;

public class PrintAToBToC {
    private final Object lock = new Object();
    private int state = 1;
    private int n;

    public PrintAToBToC(int _n) {
        this.n = _n;
    }

    private void PrintChar(int Id) {
        while (true) { 
            synchronized (lock) {
                while (state <= n && (state - 1) % 3 != Id) {
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
                switch(Id) {
                    case 0:
                        System.out.printf("A");
                        break;
                    case 1:
                        System.out.printf("B");
                        break;
                    case 2:
                        System.out.printf("C");
                        break;
                    default:
                        System.out.println("error");
                }
                ++ state;
                lock.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        PrintAToBToC t = new PrintAToBToC(n);

        Thread x = new Thread(() -> t.PrintChar(0));
        Thread y = new Thread(() -> t.PrintChar(1));
        Thread z = new Thread(() -> t.PrintChar(2));

        sc.close();

        x.start();
        y.start();
        z.start();
        
    }
}
