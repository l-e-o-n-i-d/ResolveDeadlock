package task3.join;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyThreadJoin1 extends Thread {
    private Thread myThreadOne;
    private Lock reentrantLock = new ReentrantLock();

    public void lockThread() {
        reentrantLock.lock();
        try {
            TimeUnit.MILLISECONDS.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            reentrantLock.unlock();
        }
    }
    public void setMyThreadOne(Thread myThreadOne) {
        this.myThreadOne = myThreadOne;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " start...");
        try {
            myThreadOne.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " finished...");
    }
}