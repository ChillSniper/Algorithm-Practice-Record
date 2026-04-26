package com.herbert.T1115;

import java.util.concurrent.Semaphore;

/**
 * LeetCode 1115 - Print FooBar Alternately
 * Two threads, one prints "foo", the other prints "bar", repeated n times.
 */
public class Solution {
    private final int n;
    private final Semaphore foo = new Semaphore(1);
    private final Semaphore bar = new Semaphore(0);

    public Solution(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            foo.acquire();
            printFoo.run();
            bar.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            bar.acquire();
            printBar.run();
            foo.release();
        }
    }

    // Quick local test
    public static void main(String[] args) throws InterruptedException {
        Solution s = new Solution(5);
        Thread t1 = new Thread(() -> {
            try {
                s.foo(() -> System.out.print("foo"));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                s.bar(() -> System.out.print("bar"));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
