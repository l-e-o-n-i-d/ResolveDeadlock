package task3.join;

import java.util.concurrent.TimeUnit;

public class MyThreadJoin2 extends Thread {
    private Thread myThreadTwo;
    private MyThreadJoin1 mt1;

    public void setMyThreadTwo(Thread myThreadTwo) {
        this.myThreadTwo = myThreadTwo;
        this.mt1 = (MyThreadJoin1) myThreadTwo;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " start...");
        try {
            TimeUnit.MILLISECONDS.sleep(10);
        } catch (Exception e) {
            e.printStackTrace();
        }

        mt1.lockThread();
        System.out.println(Thread.currentThread().getName() + " finished...");
    }
}
