package L010_ReEntrantLocks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class App {
    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        Runner runner = new Runner(lock);
        Thread t1 = new Thread(()->{
            try {
                runner.firstThread();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread t2 = new Thread(()->{
            try {
                runner.secondThread();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t3 = new Thread(()->{
            runner.finished();
        });

        t1.start();
        t2.start();
//        t3.start();

        t1.join();
        t2.join();
//        t3.join();
        runner.finished();
    }
}
