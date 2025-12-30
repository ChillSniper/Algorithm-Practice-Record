
// import java.util.concurrent.LinkedBlockingDeque;
// import java.util.concurrent.atomic.AtomicInteger;

/*
// using AtomicInteger + Thread.sleep(1);
class FooBar {

    private int n;

    private AtomicInteger r = new AtomicInteger(0);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            while (r.get() != 0) {
                Thread.sleep(1);
            }

            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            r.incrementAndGet();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            while (r.get() != 1) {
                Thread.sleep(1);
            }

            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            r.decrementAndGet();
        }
    }
}
 */

 /* 
class FooBar {

    final private int n;

    final private BlockingQueue<Integer> f = new LinkedBlockingDeque<>(1);
    final private BlockingQueue<Integer> b = new LinkedBlockingDeque<>(1);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            f.put(i);
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            b.put(i);
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            b.take();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            f.take();
        }
    }
}
 */
class FooBar {

    final private int n;

    volatile boolean flag = true;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n;) {
            if (flag) {
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                i++;
                flag = false;
            } else {
                Thread.yield();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n;) {

            if (!flag) {
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                i++;
                flag = true;

            } else {
                Thread.yield();
            }

        }
    }
}
