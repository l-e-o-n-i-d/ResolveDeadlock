package task3;

import task3.join.MyThreadJoin1;
import task3.join.MyThreadJoin2;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        MyThreadJoin1 myThreadOne = new MyThreadJoin1();
        MyThreadJoin2 myThreadTwo = new MyThreadJoin2();
        myThreadOne.setName("MyThread1");
        myThreadTwo.setName("MyThread2");

        myThreadOne.setMyThreadOne(myThreadTwo);
        myThreadTwo.setMyThreadTwo(myThreadOne);

        myThreadOne.start();
        myThreadTwo.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
