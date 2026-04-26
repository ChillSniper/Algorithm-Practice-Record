package com.herbert.T1115;

import java.util.concurrent.Semaphore;

public class FooBar {
    final private int n;

    // 这个 permits 原来是所谓的“许可证”数量，用来控制Semaphore的执行顺序的
    private final Semaphore x = new Semaphore(1);
    private final Semaphore y = new Semaphore(0);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            x.acquire();
        	// printFoo.run() outputs "foo". Do not change or remove this line.
        	printFoo.run();
            y.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            y.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
        	printBar.run();
            x.release();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        FooBar f = new FooBar(100);

        Thread t1 = new Thread(
            () -> {
                try {
                    f.foo(
                        () -> {
                            System.out.printf("Foo");
                        }
                    );
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        );

        Thread t2 = new Thread(
            () -> {
                try {
                    f.bar(
                        () -> {
                            System.out.printf("Bar");
                        }
                    );
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        );

        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

}
