
import java.util.concurrent.atomic.AtomicInteger;

class Foo {

    final private AtomicInteger ftosNum = new AtomicInteger(0);
    final private AtomicInteger stotNum = new AtomicInteger(0);

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();

        ftosNum.incrementAndGet();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        while (ftosNum.get() != 1) {

        }

        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();

        stotNum.incrementAndGet();
    }

    public void third(Runnable printThird) throws InterruptedException {

        while (stotNum.get() != 1) {

        }

        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
