package com.herbert.PrintABC;

public class PrintABC {
    private final Object lock = new Object();
    private int state = 0;
    private final int times;

    public PrintABC(int t) {
        this.times = t;
    }

    public void PrintA() {
        for (int i = 0;i < times;i ++) {
            synchronized (lock) {
                while (state % 3 != 0) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return ;
                    }
                }
                System.out.printf("A");
                ++ state;
                lock.notifyAll();
            }
        }
    }

    public void PrintB() {
        for (int i = 0;i < times;i ++) {
            synchronized(lock) {
                while (state % 3 != 1) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return ;
                    }
                }
                System.out.printf("B");
                ++ state;
                lock.notifyAll();
            }
        }
    }

    public void PrintC() {
        for (int i = 0;i < times;i ++) {
            synchronized (lock) {
                while (state % 3 != 2) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return ;
                    }
                }
                System.out.printf("C");
                ++ state;
                lock.notifyAll();
            }
        }
    }
    

    public static void main(String[] args) {
        PrintABC task = new PrintABC(1000);

        Thread x = new Thread(task::PrintA);
        Thread y = new Thread(task::PrintB);
        Thread z = new Thread(task::PrintC);

        x.start();
        y.start();
        z.start();
    }
}
