class Foo {
    // trick -> below
    // https://mkyong.com/java/java-semaphore-examples/
    // https://stackoverflow.com/questions/25563640/difference-between-semaphore-initialized-with-1-and-0
    Semaphore lock2, lock3;
    public Foo() {
        lock2 = new Semaphore(0);
        lock3 = new Semaphore(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        lock2.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock2.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        lock3.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        lock3.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
